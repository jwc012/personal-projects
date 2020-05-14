# * To handle everything that has to do with the CBSA database table
class Cbsa < ApplicationRecord
  MSA = 'Metropolitan Statistical Area'.freeze

  # Iterate through the data that was returned, from the zip database,
  # when the user inputted into the url, to get expected value
  #
  # @param zip_code_datas [Array]
  # - example:
  # cbsa = Cbsa.new
  # cbsa.retrieve_population_growth(array_of_data)
  # @return [Array] (data)
  def self.retrieve_population_growth(zip_code_datas)
    population_growth_output = []

    # Iterate through the array of zip_to_cbsa datas
    zip_code_datas.each do |zip_code_data|
      # Retrieve the CBSA column,
      cbsa = zip_code_data['CBSA']
      msa_data = query_msa_data(cbsa)
      population_growth_output.push(parse_msa_data(zip_code_data, msa_data))
    end

    population_growth_output
  end

  # Given a CBSA value, query the cbsa database that matches that exact CBSA
  # value or has the value as the MDIV
  #
  # @param cbsa [String]
  # - example:
  # cbsa = Cbsa.new
  # cbsa.query_msa_data("12345")
  # @return [Hash] (data)
  def self.query_msa_data(cbsa)
    # Query the CBSA database where the value of the CBSA column is the string
    # that is passed in
    queried_data_from_cbsa_to_msa = find_by_CBSA(cbsa)

    # If data was returned from the query
    if queried_data_from_cbsa_to_msa.present?

      # Query with the same cbsa string and also where the LSAD column matches
      # 'Metropolitan Statistical Area'
      queried_data_from_cbsa_to_msa = where(CBSA: cbsa, LSAD: MSA)

      # Query by MDIV column if no data was gathered using CBSA column
    elsif (queried_data_from_cbsa_to_msa = find_by_MDIV(cbsa)).present?
      # If data was gathered using the MDIV column, perform a recursion to perform
      # the correct query and gather correct data
      queried_data_from_cbsa_to_msa = query_msa_data(queried_data_from_cbsa_to_msa['CBSA'])
    else
      queried_data_from_cbsa_to_msa
    end

    queried_data_from_cbsa_to_msa
  end

  # Given all the data is collected, parse it into the format
  # the user wants to see.
  #
  # @param zip_code_data [Hash]
  # @param msa_data [Array[Hash]]
  # - example:
  # cbsa = Cbsa.new
  # cbsa.parse_msa_data({} , [{}])
  # @return [Hash]
  def self.parse_msa_data(zip_code_data, msa_data)
    name = pop_2014 = pop_2015 = 'N/A'
    if msa_data.present?
      name = msa_data.first['NAME']
      pop_2014 = msa_data.first['POPESTIMATE2014']
      pop_2015 = msa_data.first['POPESTIMATE2015']
    end

    {
      'Zip': zip_code_data['ZIP'],
      'CBSA': zip_code_data['CBSA'],
      'MSA': name,
      'Pop2015': pop_2015,
      'Pop2014': pop_2014
    }
  end
end

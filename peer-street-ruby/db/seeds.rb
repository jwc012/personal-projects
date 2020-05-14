# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
require 'open-uri'
require 'csv'

# Intializing the urls in order to download the cvs files
ZIP_TO_MSA_URL = 'https://s3.amazonaws.com/peerstreet-static/engineering/zip_to_msa/zip_to_cbsa.csv'.freeze
CBSA_TO_MSA_URL = 'https://s3.amazonaws.com/peerstreet-static/engineering/zip_to_msa/cbsa_to_msa.csv'.freeze

# The path that we want to put and get the downloaded files
ZIP_CSV_NAME_PATH = "#{Dir.pwd}/zip_to_cbsa.csv".freeze
CBSA_CSV_FILE_NAME_PATH = "#{Dir.pwd}/cbsa_to_msa.csv".freeze

# Retrieve the zip_to_cbsa file using the url and store it into our local
def save_zip_to_cbsa_file
  url_file_download = open(ZIP_TO_MSA_URL)
  IO.copy_stream(url_file_download, ZIP_CSV_NAME_PATH)
end

# Retrieve the cbsa_to_msa file using the url and store it into our local
def save_cbsa_to_msa_file
  url_file_download = open(CBSA_TO_MSA_URL)
  IO.copy_stream(url_file_download, CBSA_CSV_FILE_NAME_PATH)
end

# First clearing up the zip_to_cbsa database table and then
# inputting all the data from the csv file, skipping the header,
# into the database.
def input_zip_to_pg
  Zip.delete_all

  columns = %i[ZIP CBSA RES_RATIO BUS_RATIO OTH_RATIO TOT_RATIO]
  values = CSV.read(Rails.root.join(ZIP_CSV_NAME_PATH))[1..-1]

  Zip.import columns, values
end

# First clearing up the cbsa_to_msa database table and then
# inputting all the data from the csv file, skipping the header,
# into the database.
def input_cbsa_to_pg
  Cbsa.delete_all

  columns = %i[
      CBSA MDIV STCOU NAME LSAD CENSUS2010POP ESTIMATESBASE2010 POPESTIMATE2010 POPESTIMATE2011
      POPESTIMATE2012 POPESTIMATE2013 POPESTIMATE2014 POPESTIMATE2015 NPOPCHG2010 NPOPCHG2011 NPOPCHG2012
      NPOPCHG2013 NPOPCHG2014 NPOPCHG2015 BIRTHS2010 BIRTHS2011 BIRTHS2012 BIRTHS2013 BIRTHS2014
      BIRTHS2015 DEATHS2010 DEATHS2011 DEATHS2012 DEATHS2013 DEATHS2014 DEATHS2015 NATURALINC2010
      NATURALINC2011 NATURALINC2012 NATURALINC2013 NATURALINC2014 NATURALINC2015 INTERNATIONALMIG2010
      INTERNATIONALMIG2011 INTERNATIONALMIG2012 INTERNATIONALMIG2013 INTERNATIONALMIG2014 INTERNATIONALMIG2015
      DOMESTICMIG2010 DOMESTICMIG2011 DOMESTICMIG2012 DOMESTICMIG2013 DOMESTICMIG2014 DOMESTICMIG2015
      NETMIG2010 NETMIG2011 NETMIG2012 NETMIG2013 NETMIG2014 NETMIG2015 RESIDUAL2010 RESIDUAL2011
      RESIDUAL2012 RESIDUAL2013 RESIDUAL2014 RESIDUAL2015
    ]
  values = CSV.read(Rails.root.join(CBSA_CSV_FILE_NAME_PATH), encoding: 'iso-8859-1:utf-8')[1..-1]

  Cbsa.import columns, values
end

save_zip_to_cbsa_file
input_zip_to_pg
save_cbsa_to_msa_file
input_cbsa_to_pg
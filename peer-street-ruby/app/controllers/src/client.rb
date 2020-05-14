class Client
  require 'rest-client'
  require 'json'

  def local_host_api
    'http://localhost:3000/api/v1/peer_street/'
  end

  def heroku_host_api
    'https://peerstreet-jwc012.herokuapp.com/api/v1/peer_street/'
  end

  def population_growth_url(route, zip_code)
    route += zip_code.to_s
  end

  def zip_code
    zip_code = ''
    zip_code = gets
    zip_code.chomp
  end

  def get_population_growth_data(url)
    begin
      RestClient.get(url)
    rescue RestClient::ExceptionWithResponse => e
      puts e.response
    rescue RestClient::Exceptions::Timeout, Errno::ECONNREFUSED => e
      puts 'The API service cannot be connected at this time, there is a connection error or the service is currently under maintenance.'
      puts 'Please check your connection or try again later.'
      exit(1)
    end
  end
end

loop do
  client = Client.new

  puts "\nPlease enter the desired zip code (q to terminate the program)\n"

  zip_code = client.zip_code

  exit(1) if zip_code.casecmp('q').zero?

  if zip_code.length != 5
    puts 'The zip code needs to be 5 digits'
  else
    # host_route = client.local_host_api
    host_route = client.heroku_host_api
    api_route = client.population_growth_url(host_route, zip_code)
    population_data = client.get_population_growth_data(api_route)
    unless population_data.nil?
      puts JSON.pretty_generate(JSON.parse(population_data.body))
    end
  end
end
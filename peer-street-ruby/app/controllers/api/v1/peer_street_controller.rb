module Api
  module V1
    class PeerStreetController < ApplicationController

      # Get api call where the user passes in 5 digit zip code as a param
      #
      # @return json
      def show
        # Find the data in the Zip database where the value of the Zip column
        # matches the user's input
        @zip_code_datas_from_zip_to_cbsa = Zip.where(ZIP: params[:id])

        # If data is returned, perform the necessary task of outputting the json response
        if @zip_code_datas_from_zip_to_cbsa.present?
          output = Cbsa.retrieve_population_growth(@zip_code_datas_from_zip_to_cbsa)
          if output.present?
            render json: { data: output }, status: :ok
          else
            render json: {
              status: 'FAIL',
              message: 'Cannot find data matching the CBSA'
            }, status: :not_found
          end
        else
          render json: {
            status: 'FAIL',
            message: 'Inputted zip code cannot be found. Please input a new 5 digit zip code'
          }, status: :not_found
        end
      end
    end
  end
end

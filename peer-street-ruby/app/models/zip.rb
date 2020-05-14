class Zip < ApplicationRecord
  validates :ZIP, presence: true
  validates :CBSA, presence: true
end

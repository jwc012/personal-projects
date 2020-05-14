class CreateZips < ActiveRecord::Migration[6.0]
  def change
    create_table :zips do |t|
      t.string :ZIP
      t.string :CBSA
      t.string :RES_RATIO
      t.string :BUS_RATIO
      t.string :OTH_RATIO
      t.string :TOT_RATIO

      t.timestamps
    end
  end
end

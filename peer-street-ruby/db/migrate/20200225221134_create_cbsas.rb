class CreateCbsas < ActiveRecord::Migration[6.0]
  def change
    create_table :cbsas do |t|
      t.string :CBSA
      t.string :MDIV
      t.string :STCOU
      t.string :NAME
      t.string :LSAD
      t.string :CENSUS2010POP
      t.string :ESTIMATESBASE2010
      t.string :POPESTIMATE2010
      t.string :POPESTIMATE2011
      t.string :POPESTIMATE2012
      t.string :POPESTIMATE2013
      t.string :POPESTIMATE2014
      t.string :POPESTIMATE2015
      t.string :NPOPCHG2010
      t.string :NPOPCHG2011
      t.string :NPOPCHG2012
      t.string :NPOPCHG2013
      t.string :NPOPCHG2014
      t.string :NPOPCHG2015
      t.string :BIRTHS2010
      t.string :BIRTHS2011
      t.string :BIRTHS2012
      t.string :BIRTHS2013
      t.string :BIRTHS2014
      t.string :BIRTHS2015
      t.string :DEATHS2010
      t.string :DEATHS2011
      t.string :DEATHS2012
      t.string :DEATHS2013
      t.string :DEATHS2014
      t.string :DEATHS2015
      t.string :NATURALINC2010
      t.string :NATURALINC2011
      t.string :NATURALINC2012
      t.string :NATURALINC2013
      t.string :NATURALINC2014
      t.string :NATURALINC2015
      t.string :INTERNATIONALMIG2010
      t.string :INTERNATIONALMIG2011
      t.string :INTERNATIONALMIG2012
      t.string :INTERNATIONALMIG2013
      t.string :INTERNATIONALMIG2014
      t.string :INTERNATIONALMIG2015
      t.string :DOMESTICMIG2010
      t.string :DOMESTICMIG2011
      t.string :DOMESTICMIG2012
      t.string :DOMESTICMIG2013
      t.string :DOMESTICMIG2014
      t.string :DOMESTICMIG2015
      t.string :NETMIG2010
      t.string :NETMIG2011
      t.string :NETMIG2012
      t.string :NETMIG2013
      t.string :NETMIG2014
      t.string :NETMIG2015
      t.string :RESIDUAL2010
      t.string :RESIDUAL2011
      t.string :RESIDUAL2012
      t.string :RESIDUAL2013
      t.string :RESIDUAL2014
      t.string :RESIDUAL2015

      t.timestamps
    end
  end
end

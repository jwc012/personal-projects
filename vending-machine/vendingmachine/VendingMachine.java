/** YOU CAN DO IT!!
 * Standard Masimo Coding Exercise
**/
package vendingmachine;

import java.util.HashMap;

/**
 * @Class: Vending Machine
 * @Description: To create a class constructor for vending machine. 
 * @Created by: Ji Woon Chung
 */
public class VendingMachine {

    // Creating a hashmap variable that will store specific id that goes along 
    // with the items
    private final HashMap<String, Items> inventory;
    // Creating a hashmap variable that will store specific key that goes along
    // with the money
    private final HashMap<String, Money> currencyInserted;
    // Creating variables for vending machine
    private double total;
    private final String resetButton;
    private boolean abortFlag;
    private final double max;

    /**
    * @Method: Vending Machine constructor.
    * @Description: A default class constructor for the Vending Machine
    */
    protected VendingMachine(){
        // What will go inside the vending machine at the beginning of the construction
        this.inventory = new HashMap<>();
        this.currencyInserted = new HashMap<>();
        // Will have no money inside the vending machine
        this.total = 0.0;
        // The reset button will be a 'R' character
        this.resetButton = "R";
        this.abortFlag = false;
        // The max amount this vending machine can take is a dollar
        this.max = 1.00;
    }

    /**
    * @Method: A setter function to add items to the vending machine.
    * @Description: To add items into the vending machine
    * @Input: 
    *   @key - String = The id of the item
    *   @item - Item = the item
    */
    protected void addItem(String key, Items item){
        inventory.put(key, item);
    }
    
    /**
    * @Method: A setter function to end the vending machine program or not
    * @Description: A flag to end the program or not
    * @Input: 
    *   @abortFlag - boolean: To end the program or not
    */
    protected void setAbortFlag(boolean abortFlag){
        this.abortFlag = abortFlag; 
    }

    /**
    * @Method: A setter function to add specific amount to the vending machine
    * @Description: to add specific amount to the vending machine
    * @Input: 
    *   @key - String: A specific character that represents the coin
    *   @money - Money: Money
    */    
    protected void addCurrency(String key, Money money){
        currencyInserted.put(key, money);
    }
    
    /**
    * @Method: A total setter function
    * @Description: To set the total amount that is inside the vending machine
    * @Input: 
    *   @total - double: Money amount
    */    
    protected void setTotal(double total){
        this.total = total;
    }
    
    /**
    * @Method: The item getter function
    * @Description: To return the item inside the vending machine
    * @Output - The item
    */    
    protected HashMap<String, Items> getInventory() {
        return this.inventory;
    }
    
    /**
    * @Method: The money getter function
    * @Description: To return the money that was inserted into the vending machine
    * @Output - The money
    */    
    protected HashMap<String, Money> getCurrency() {
        return this.currencyInserted;
    }
    
    /**
    * @Method: The reset getter function
    * @Description: To return the state of the vending machine
    * @Output - true or false depending on the state of the vending machine
    */    
    protected boolean getAbortFlag(){
        return this.abortFlag;
    }
 
    /**
    * @Method: A total money getter function
    * @Description: To return the total money inside the vending machine
    * @Output - The total amount that is inside the vending machine (double)
    */       
    protected double getTotal(){
        return this.total;
    }
    
    /**
    * @Method: The getter function to get the reset button
    * @Description: To return the reset button of the vending machine
    * @Output - The reset button of the vending machine (String)
    */        
    protected String getResetButton(){
        return this.resetButton;
    }

    /**
    * @Method: The getter function to get the max amount the vending machine can take
    * @Description: To return the max amount the vending machine can take
    * @Output - The max amount the vending machine can take (double)
    */            
    protected double getMax(){
        return this.max;
    }
}
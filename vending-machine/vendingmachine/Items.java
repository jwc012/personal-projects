package vendingmachine;

/**
 * @Class: Items
 * @Description: To create a class constructor which allows the user to create 
 *      the items that will go inside the vending machine. 
 * @Created by: Ji Woon Chung
 */
public class Items {

    // Creating the necessary variables, to describe the item that will go
    // inside the vending machine
    private final String name;
    private final double price;
    private int stock;

    /**
    * @Method: Item constructor.
    * @Description: An item constructor for the items that will go 
    *       inside the vending machine. 
    * @Input: 
    *   @name = The name of the item
    *   @price = The price of the item
    *   @initialStock = The inventory stock of the item inside the vending machine
    */
    protected Items(String name, double price, int initialStock) {
        this.name = name;
        this.price = price;
        this.stock = initialStock;
    }
    
    /**
    * @Method: Name getter Function for Items.
    * @Description: To get the name of the item 
    * @Output: The name of the item (String)
    */
    protected String getName() {
        return this.name;
    }
    
    /**
    * @Method: Price getter Function for Items.
    * @Description: To get the price of the item 
    * @Output: The price of the item (double)
    */
    protected double getPrice() {
        return this.price;
    }

    /**
    * @Method: Inventory getter Function for Items.
    * @Description: To get the inventory of the item 
    * @Output: The inventory of the item 
    */
    protected double getStock() {
        return this.stock; 
    }

    /**
    * @Method: To decrease the stock amount by one.
    * @Description: To decrease the inventory of the item by one 
    */
    protected void decreaseStock() {    
        this.stock--;
    }
    
    /**
    * @Method: To increase the stock amount by one.
    * @Description: To decrease the inventory of the item by one 
    */
    protected void increaseStock() {
        this.stock++;
    }
}
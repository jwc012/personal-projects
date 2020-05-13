package vendingmachine;

/**
 * @Class: Money
 * @Description: To create a class constructor for Money. 
 * @Created by: Ji Woon Chung
 */
public class Money {
    // Creating the necessary variables, to describe the money that will go
    // inside the vending machine
    private final double currency;
    private final String nameOfCoin;
    
    /**
    * @Method: Money constructor.
    * @Description: A constructor for the money that will go inside 
    *       the vending machine. 
    * @Input: 
    *   @nameOfCoin - String = The name of the coin/money
    *   @currency - double = The amount of the money
    */
    protected Money(String nameOfCoin, double currency){
        this.nameOfCoin = nameOfCoin;
        this.currency = currency;
    }

    /**
    * @Method: Currency getter Function.
    * @Description: To get the specific amount user inputted
    * @Output: The money amount the user inputted (double)
    */
    protected double getCurrency(){
        return currency;
    }
    
    /**
    * @Method: Name getter Function.
    * @Description: To get the name of the coin
    * @Output: The name of a specific coin (String)
    */
    protected String getNameOfCoin(){
        return nameOfCoin;
    }
}

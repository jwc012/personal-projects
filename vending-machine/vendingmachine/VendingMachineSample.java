/*
 * @Project: Vending Machine
 * @Description: Programming a real life Vending Machine. A vending machine that
 *      can currently only take in coins: nickels, dimes, or quarters, (but can 
 *      change in the future). The user can enter in an id to make a selection 
 *      of an item within the vending machine and can abort (reset) at anytime. 
 *      The vending machine will display the total amount, amount entered, 
 *      returns balance of funds, success or failure, and the number of 
 *      inventory of an item. 
 * @Created by: Ji Woon Chung
 */
package vendingmachine;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Ji Woon Chung
 */
public class VendingMachineSample {    
    
    public static void main(String[] args) {
        // Create items
        Items FIRST_ITEM = new Items("OVEN BAKED ORIGINAL LAY'S CHIP", 0.55, 10);
        Items SECOND_ITEM = new Items("POPCORNERS KETTLE", 0.70, 10);
        Items THIRD_ITEM = new Items("SUN CHIPS FRENCH ONION", 0.75, 10);
         // Create money 
        Money NICKEL = new Money("Nickel", .05);
        Money DIME = new Money("Dime", .10);
        Money QUARTER = new Money("Quarter", .25);
        // Create Vending Machine
        VendingMachine vm = new VendingMachine();
        // Add items into vending machine with specific key associated with it
        vm.addItem("A1", FIRST_ITEM);
        vm.addItem("A2", SECOND_ITEM);
        vm.addItem("A3", THIRD_ITEM);
        // Add allowed currency into vending Machine with specific key associated
        // with it
        vm.addCurrency("N", NICKEL);
        vm.addCurrency("D", DIME);
        vm.addCurrency("Q", QUARTER);
        // Outputting/detailing to the user what is currently in the vending machine
        System.out.println("Hello hungry customer, here are the current "
                + "available selections that are within the Vending Machine:");
        // Creating columns
        System.out.println("ID" + "\t\t" + "Name" + "\t\t\t\t" + "Price" + "\t" 
                + "Stock");    
        // Display options/items inside the vending machine
        // for loop to go through all the items inside the vending machine
        vm.getInventory().entrySet().forEach((entry) -> {
            // Getting the id of specific item
            String key = entry.getKey();
            // Getting the item that is inside the inventory
            Items item = entry.getValue();
            // Printing out the items
            System.out.printf("%-10s %-35s %-10s %-10s\n", key, item.getName(),
                    NumberFormat.getCurrencyInstance().format(item.getPrice()),
                    (int) item.getStock());
        });
        System.out.println("\n" + "If you ever change your mind and do not want to "       
                + "purchase an item, please feel free to enter in the "       
                + "character, '" + vm.getResetButton() 
                + "', to abort and return the coin/s inserted." + "\n");
        // Informing the user the specific keys assocaited with the coins
        vm.getCurrency().entrySet().forEach((entry) -> {
            String key = entry.getKey();
            Money currency = entry.getValue();
            System.out.println("'" + key + "'" + " for " + currency.getNameOfCoin());
        });
    
        // A string variable to hold the max currency
        String maxMoney = NumberFormat.getCurrencyInstance().format(vm.getMax());
        // Creating a scanner object to take in user's inputs
        Scanner scan = new Scanner(System.in);
        // To run until the user presses the abort button
        while(vm.getAbortFlag() == false) {
            // Getting the user's inputs
            String valueEntered = scan.nextLine();   
            // If the user inputs the reset/abort button
            if (vm.getResetButton().equals(valueEntered)){
                // If the user has entered in the abort key, the total amount
                // that is inside the vending machine will be refunded.
                System.out.println("Here is the total funds returned: " 
                        + NumberFormat.getCurrencyInstance().format(vm.getTotal()));
                // The total amount that is inside the vending machine is now turned
                // to zero
                vm.setTotal(0);
                // To end this vending machine
                vm.setAbortFlag(true);
            }
            // If the user inputs the key associated with the money
            else if (vm.getCurrency().containsKey(valueEntered)) {
                // Get the money
                Money currency = vm.getCurrency().get(valueEntered);
                // A string variable to hold the current currency amount
                String currencyInserted = NumberFormat.getCurrencyInstance().format(currency.getCurrency());
                // If the amount entered does not go over the max amount the vending machine can take
                if ((Math.round((vm.getTotal() + currency.getCurrency()) * 100.0) / 100.0) <= vm.getMax()){
                    // Informing the user how much he/she has inputted
                    System.out.println("You have entered in " + currencyInserted);
                    // Putting the money into the vending machine 
                    vm.setTotal(vm.getTotal() + currency.getCurrency());
                    // Informing the user how much money is in the vending machine
                    System.out.println("The total amount that is currently in the " 
                            + "Vending Machine is " + NumberFormat.getCurrencyInstance().format(vm.getTotal()));
                }
                // If the money does not go over the max amount the vending machine can take
                else {
                    System.out.println("The current max fund this vending machine takes is "                
                            + maxMoney + ". Please select one of the available items inside "
                            + "the vending machine before entering in more coins."); 
                    // Informing the user how much money is in the vending machine 
                    // at the moment
                    System.out.println("The total amount that is currently in the vending machine is "
                            + NumberFormat.getCurrencyInstance().format(vm.getTotal()));
                    // Informing the user that the money entered has been returned/rejected
                    System.out.println("The " + currencyInserted + " has been returned");
                
                }
            }
            // If the user inputs the key associated with the items inside the vending machine
            else if (vm.getInventory().containsKey(valueEntered)){
                // Getting the item
                Items item = vm.getInventory().get(valueEntered);
                // To check if the user can purchase the item selected
                if ((Math.round(vm.getTotal() * 100.0) / 100.0) >= item.getPrice()){
                    // To check if the item is inside the vending machine
                    if (item.getStock() > 0 ) {
                        // Decrease the stock by one
                        item.decreaseStock();
                        // Set the total amount that is inside the vending machine
                        vm.setTotal(vm.getTotal() - item.getPrice());
                        // Informing the user what he/she has purchased and how much the item cost
                        System.out.println("You have just purchased " 
                                + item.getName() + " for " 
                                + NumberFormat.getCurrencyInstance().format(item.getPrice()));
                        // Informing the user how much he/she has left over after the purchase
                        System.out.println("The total amount that is currently in the " 
                                + "Vending Machine is " 
                                + NumberFormat.getCurrencyInstance().format(vm.getTotal()));
                        // Informing the user the item's inventory that is in the vending machine
                        System.out.println("The amount of " + item.getName() 
                                + " that is inside the vending machine is " 
                                + (int) item.getStock());
                    }
                    // When the item ran out
                    else{
                        // Informing the user that the item selected has currently ran out.
                        System.out.println("The " + item.getName()
                                + " is currently out of stock. Please select one of the other "
                                + "available items inside the vending machine.");
                    }
                }
                // When the user does not have enough money to purchase the item
                else {
                    //Informing the user that he/she does not have enough money to
                    // purchase the item selected
                    System.out.println("Sorry, but you have not entered/inputted"
                            + " sufficient amount of funds into the system for the "
                            + item.getName() + ". Please enter in more coins.");
                    // Informing that the machine is returning the coins inserted
                    System.out.println("Here are the total funds retured: " 
                            + NumberFormat.getCurrencyInstance().format(vm.getTotal()));
                    vm.setTotal(0);
                }
            }
            // If the user has not inputted the correct character
            else 
                // Inform the user that he/she has inputted an invalid character/action
                System.out.println("You have entered in an invalid character or "
                        + "ID, please try again.");
        }
        scan.close();
    }
}
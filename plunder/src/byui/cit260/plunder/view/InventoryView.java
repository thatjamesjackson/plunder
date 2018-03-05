/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import static byui.cit260.plunder.control.InventoryControl.calculateWeight;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author abigailking
 */
public class InventoryView {

    private String instructions;
    private String promptMessage;

    public void display() {

        boolean endView = false;
        do {

            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }

            endView = doAction(inputs);
        } while (endView != true);
    }

    private String[] getInputs() {
//        System.out.println("GET INPUTS CALLED");
//        String[] inputs = new String[1];
//        inputs[0] = "testInput";
        Random random = new Random();

        double[] itemWeight = {random.nextInt(301), random.nextInt(301)};
        double[] itemQuantity = {random.nextInt(11), random.nextInt(11)};

        double weight = InventoryControl.calculateWeight(itemWeight, itemQuantity);

        String[] inputs = new String[1];

        this.instructions
                = "\n  Our ship be sitting at " + weight + "tonnes\n"
                + "===============================================\n"
                + "           What do ya want to do?\n"
                + "              L - List Inventory\n"
                + "              S - Sell all loot\n"
                + "              D - Drop Cargo\n"
                + "              R - Return to navigation"
                + "===============================================\n";
        
        this.promptMessage = "Enter your selection below: ";

        String input1 = this.getInput();
        if (input1.equals(input1.toUpperCase().equals("Q"))) {
            return inputs;
        }
        inputs[0] = input1;
        
        return inputs;

  
    }

    private String getInput() {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        String value = "";
        
         System.out.println(this.instructions);

        while (valid == false) {
            System.out.println(this.promptMessage);

            value = scan.nextLine();
            value = value.trim();

            if (value.length() < 1) {
                System.out.println("You must enter a value.");
                continue;
            }

            valid = true;
        }
        return value;

    }

    private boolean doAction(String[] inputs) {
        switch (inputs[0].toUpperCase()) {
            case "L":
                listInventory();
                break;

            case "S":
                sellShop();
                break;

            case "D":
                return this.dropCargo();

            case "R":
                break;

            default:
                System.out.println("Invalid Menu Item");

        }
        return false;
    }

    private boolean dropCargo() {

        this.instructions = "Here is your inventory. What do you wanna drop?\n"
                + "C - cotton - 2 tonnes\n"
                + "G - gold - 10 tonnes\n"
                + "B - cannon balls - 20 tonnes";
        
        this.promptMessage = this.promptMessage = "Enter your selection below: ";

        String itemType = this.getInput();
        if (itemType.equals(itemType.toUpperCase().equals("Q"))) {
            return true;
        }
        
        // get amount
        double howMuch = 2;
        String item = "cotton";
        
        this.instructions = "You have " + howMuch + " tonnes of " + item + " in your inventory.";
        
        this.promptMessage = this.promptMessage = "Enter a number value of how much to drop below: ";

        String amount = this.getInput();
        if (amount.equals(amount.toUpperCase().equals("Q"))) {
            return true;
        }
        
        // new calculation
        
        return true;
    }

    private void listInventory() {
        
    }

    private void sellShop() {
        
    }

}

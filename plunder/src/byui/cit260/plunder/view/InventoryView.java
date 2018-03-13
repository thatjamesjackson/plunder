/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import static byui.cit260.plunder.control.InventoryControl.calculateWeight;
import plunder.Plunder;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author abigailking
 */


public class InventoryView extends View{

    private String instructions;
    private String promptMessage;
    private String[] inputs = new String[3];
    
    public void display() {

    }

    @Override
    public String[] getInputs() {
        Random random = new Random();

        double[] itemWeight = {random.nextInt(301), random.nextInt(301)};
        double[] itemQuantity = {random.nextInt(11), random.nextInt(11)};

        double weight = InventoryControl.calculateWeight(itemWeight, itemQuantity);

        this.instructions
                = "\n  Our ship be sitting at " + weight + "tonnes\n"
                + "===============================================\n"
                + "           What do ya want to do?\n"
                + "              L - List Inventory\n"
                + "              S - Sell all loot\n"
                + "              D - Drop Cargo\n"
                + "              R - Return to navigation\n"
                + "===============================================\n";
        
        this.promptMessage = "Enter your selection below: ";

        String input1 = this.getInput(this.promptMessage);
        
        if (input1.equals(input1.toUpperCase().equals("Q"))) {
            return inputs;
        }
        this.inputs[0] = input1;
        
        switch (inputs[0].toUpperCase()) {
            case "L":
                listInventory();
                break;

            case "S":
                sellShop();
                break;

            case "D":
                this.dropCargo();
                break;

            case "R":
                inputs[0] = "Q";
                break;
                
            default:
                System.out.println("Invalid Menu Item");

        }
  
        
        return inputs;
  
    }

    @Override
    public boolean doAction(String[] inputs) {

        int howMuch = InventoryControl.howMuch(itemType, p.getCurrentGame().getInventory());
        
        // new calculation
        
        int inventoryQuantity = howMuch - Integer.parseInt(this.inputs[2]);
        InventoryControl.changeQuantity(howMuch, p.getCurrentGame().getInventory(), itemType);
        
        return true;
    }

    private void dropCargo() {

        this.instructions = "Here is your inventory. What do you wanna drop?\n"
                + "C - cotton - 2 tonnes\n"
                + "G - gold - 10 tonnes\n"
                + "B - cannon balls - 20 tonnes";
        
        this.promptMessage = this.promptMessage = "Enter your selection below: ";

        String itemType = this.getInput(this.promptMessage);
        if (itemType.equals(itemType.toUpperCase().equals("Q"))) {
            return;
        }
        
        this.inputs[1] = itemType;
        
        // get amount
        Plunder p = new Plunder();
        
        int howMuch = InventoryControl.howMuch(itemType, p.getCurrentGame().getInventory());
        
        this.instructions = "You have " + howMuch + " tonnes of " + itemType + " in your inventory.";
        
        this.promptMessage = "Enter a number value of how much to drop below: ";

        String amount = this.getInput(this.promptMessage);
        if (amount.equals(amount.toUpperCase().equals("Q"))) {
            return;
        }
        
        this.inputs[2] = itemType;
        
        return;
        
    }

    private void listInventory() {
        
    }

    private void sellShop() {
        
    }

}

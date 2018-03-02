/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import static byui.cit260.plunder.control.InventoryControl.calculateWeight;
import java.util.Scanner;

/**
 *
 * @author abigailking
 */
public class InventoryView {
    public void display() { 
        double[] itemWeight = {100,200};
        double[] itemQuantity = {10,5};
        
        double weight = InventoryControl.calculateWeight(itemWeight, itemQuantity);
        
        boolean endView = false; 
        do{
             System.out.println(
                                "  Our ship be sitting at " + weight + "tonnes\n"
                              + "===============================================\n"
                              + "           What do ya want to do?\n"
                              + "              L - List Inventory\n"
                              + "              S - Sell all loot\n"
                              + "              D - Drop Cargo\n"
                              + "              R - Return to navigation");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }
            
        endView = doAction(first);
    } while(endView != true);
}

    private String[] getInputs() {
        
        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }

    private boolean doAction(String input) {
        
        switch (input) {
            case "L":
                listInventory();
                break;

            case "S":
                sellShop();
                break;
                
            case "D":
                dropCargo();
                break;
                
            case "R":
                return true;

            default:
                System.out.println("Invalid Menu Item");

        }
        return false; 
    }

    private void listInventory() {
        
    }

    private void sellShop() {
        
    }

    private void dropCargo() {
        System.out.println("Here is your inventory. What do you wanna drop?\n" +
                           "C - cotton - 2 tonnes\n" +
                           "G - gold - 10 tonnes\n" +
                           "B - cannon balls - 20 tonnes");
        
        // get input as to what to drop
        //String[] dropWhat = new String[1];
        //Scanner scan = new Scanner(System.in);
        //dropWhat[0] = scan.nextLine();
        //return dropWhat;
        
        // how much to drop
        //System.out.println("How much of " + dropWhat + " do you want to unload?");
    }
}

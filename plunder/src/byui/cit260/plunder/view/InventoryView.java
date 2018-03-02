/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import static byui.cit260.plunder.control.InventoryControl.calculateWeight;
import java.util.Scanner;

/**
 *
 * @author abigailking
 */
public class InventoryView {
    public void display() { 
        
        InventoryControl weight = calculateWeight(double[] itemWeight, double[] itemQuantity);
        
        boolean endView = false; 
        do{
             System.out.println(
                                "     Our ship be sitting at " + weight + "tonnes"
                                "============================================\n" +
                                "           What do ya want to do?\n" +
                                "              B - Buy\n" +
                                "              S - Sell all loot\n" +
                                "              D - Drop Cargo\n" +
                                "              R - Return to ship");
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
            case "B":
                buyShop();
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

    private void buyShop() {
        
    }

    private void sellShop() {
        
    }

    private void dropCargo() {
        
    }
}

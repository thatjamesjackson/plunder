/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.Ship;
import java.util.ArrayList;

/**
 *
 * @author abigailking
 */
public class InventoryControl {

    public static double sellAll(Ship ship) {
        double gold = 0;
        ArrayList inventory = ship.getInventory();
        for (Object curItem : inventory) {
            InventoryItem item = (InventoryItem) curItem;
            gold = gold + (item.getQuantityInStock() * item.getValue());
            item.setQuantityInStock(0);
        }
        return gold;
    }

    public static double calculateWeight(double[] itemWeight, double[] itemQuantity) {

        // check all weights are not less than 0
        for (int i = 0; i < itemWeight.length; i++) {
            if (itemWeight[i] < 0) {
                return - 1;
            }
        }

        // check all quantities are not less than 0
        for (int i = 0; i < itemQuantity.length; i++) {
            if (itemQuantity[i] < 0) {
                return - 2;
            }
        }

        //this can’t go on the test table, but both arrays have to be the same length
        if (itemWeight.length != itemQuantity.length) {
            return - 3;
        }

        //declare weight
        double weight = 0;

        /*calculate weight it does not matter which array 
         * length you use as we just checked they were the same length*/
        for (int i = 0; i < itemWeight.length; i++) {
            weight += itemQuantity[i] * itemWeight[i];
        }
        return weight;
    }

    public static int howMuch(String displayLetter, ArrayList<InventoryItem> inventoryItems) {

        int verMuch = 0;

        for (InventoryItem i : inventoryItems) {
            if (i.getInventoryType().equals(displayLetter)) {
                verMuch = i.getQuantityInStock();
            }
        }

        return verMuch;
    }

    public static int itemSearch(String displayLetter, ArrayList<InventoryItem> inventoryItems) {

        int verMuch = 0;

        for (InventoryItem i : inventoryItems) {
            if (i.getInventoryType().equals(displayLetter)) {
                verMuch = i.getQuantityInStock();
            }
        }

        return verMuch;
    }

    public static void changeQuantity(int amount, ArrayList<InventoryItem> inventoryItems, String type) {

        for (InventoryItem i : inventoryItems) {
            if (i.getInventoryType().equals(type)) {
                i.setQuantityInStock(amount);
            }
        }
    }

}

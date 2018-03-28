/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.Ship;
import exceptions.InventoryControlException;
import java.util.ArrayList;

/**
 *
 * @author abigailking
 */
public class InventoryControl {

    public static double sellAll(Ship ship) throws InventoryControlException {
        double gold = 0;
        ArrayList inventory = ship.getInventory();
        for (Object curItem : inventory) {
            InventoryItem item = (InventoryItem) curItem;
            if(item.getQuantityInStock() < 0 || item.getValue() < 0)
                throw new InventoryControlException("Quantity and/ or value is less than 0");
            gold = gold + (item.getQuantityInStock() * item.getValue());
            item.setQuantityInStock(0);
        }
        return gold;
    }

    public static double calculateWeight(Ship ship) throws InventoryControlException {

               double weight = 0;
        ArrayList inventory = ship.getInventory();
        for (Object curItem : inventory) {
            InventoryItem item = (InventoryItem) curItem;
            if(item.getQuantityInStock() < 0 || item.getWeight() < 0)
                throw new InventoryControlException("Quantity and/ or weight is less than 0");
            weight = weight + (item.getQuantityInStock() * item.getWeight());
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

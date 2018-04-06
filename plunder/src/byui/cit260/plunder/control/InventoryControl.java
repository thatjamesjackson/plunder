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
            if (item.getQuantityInStock() < 0 || item.getValue() < 0) {
                throw new InventoryControlException("Quantity and/ or value is less than 0");
            }
            if (item.getQuantityInStock() == 0) {
                continue;
            }
            double addedValue = (item.getQuantityInStock() * item.getValue());
            gold += addedValue;
            System.out.println("Sold " + item.getQuantityInStock()
                    + " " + item.getInventoryType()
                    + " for " + addedValue + " gold");
            item.setQuantityInStock(0);
        }
        return gold;
    }

    public static double calculateWeight(Ship ship) throws InventoryControlException {

        double weight = 0;
        ArrayList inventory = ship.getInventory();
        for (Object curItem : inventory) {
            InventoryItem item = (InventoryItem) curItem;
            if (item.getQuantityInStock() < 0 || item.getWeight() < 0) {
                throw new InventoryControlException("Quantity and/ or weight is less than 0");
            }
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

    public static ArrayList<InventoryItem> sortInventory(ArrayList<InventoryItem> inventoryItems) {
        ArrayList<InventoryItem> items = (ArrayList<InventoryItem>) inventoryItems.clone();
        int n = items.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                String first = items.get(i).getTypeAbr();
                String second = items.get(k).getTypeAbr();
                if (first.compareTo(second) > 0) {
                    InventoryControl.swapNumbers(i, k, items);
                }
            }
        }
        return items;
    }

private static void swapNumbers(int i, int j, ArrayList<InventoryItem> inventoryItems) {
  
        InventoryItem temp = inventoryItems.get(i);
        InventoryItem tempTwo = inventoryItems.get(j);
        inventoryItems.set(j, temp);
        inventoryItems.set(i, tempTwo);
    }

}

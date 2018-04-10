/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.InventoryItem;
import exceptions.InventoryControlException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class DropView extends View {

    @Override
    public String[] getInputs() {

        //get inputs from user
        String[] inputs = new String[1];
        inputs[0] = this.getInput(
                "================================ \n"
                + "        Do ye want to:\n"
                + "   A  - Drop all of an item\n"
                + "   P  - Drop part of an item\n"
                + "   Q  - Quit \n");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        ArrayList<InventoryItem> yerInventory = Plunder.getCurrentGame().getInventory();
        inputs[0] = inputs[0].toUpperCase().trim();

        switch (inputs[0]) {
            case "A":
                allDrop(yerInventory);
                break;

            case "P":
                partDrop(yerInventory);

            default:
                this.console.println("Invalid Menu Item");

        }

        return true;
    }

    private void allDrop(ArrayList<InventoryItem> inventory) {
        InventoryView inv = new InventoryView();
        inv.listInventory();
        String input = getInput("Which item do ye want to get all rid of?");
        input = input.toUpperCase().trim();
        InventoryControl.changeQuantity(0, inventory, input);
    }

    private void partDrop(ArrayList<InventoryItem> inventory) {
        InventoryView inv = new InventoryView();
        inv.listInventory();
        String input = getInput("What item do ye want to drop a certain part of?");
        input = input.toUpperCase().trim();
        int num;
        try {
            num = parseInt(getInput("How much do ye want to drop?"));
        } catch (NumberFormatException ex) {
            System.out.println("Ye must enter a number");
            return;
        }
        InventoryItem item;
        try {
            item = inventory.get(InventoryControl.itemSearch(input, inventory));
        } catch (InventoryControlException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        //if they try and drop more than they have, just drop all
        if (num > item.getQuantityInStock()) {
            num = item.getQuantityInStock();
        }
        InventoryControl.changeQuantity(item.getQuantityInStock() - num, inventory, input);

    }

}

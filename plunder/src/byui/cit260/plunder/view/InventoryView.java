/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import static byui.cit260.plunder.control.InventoryControl.sortInventory;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.Ship;
import exceptions.InventoryControlException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import plunder.Plunder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abigailking
 */
public class InventoryView extends View {

    private String instructions;
    private String promptMessage;
    private String[] inputs = new String[3];

    @Override
    public String[] getInputs() {
        Ship ship = Plunder.getCurrentGame().getPlayer().getShip();

        double weight = 0;

        try {
            weight = InventoryControl.calculateWeight(ship);
        } catch (InventoryControlException ex) {
            System.out.println(ex.getMessage());
        }
listInventory();
        this.promptMessage
                = "\n  Our ship be sitting at " + weight + " tonnes\n"
                + "===============================================\n"
                + "           What do ya want to do?\n"
                + "              D - Drop Cargo\n"
                + "              R - Return to navigation\n"
                + "===============================================\n"
                + "           Enter your selection below: ";
        
        String input1 = this.getInput(this.promptMessage);

        if (input1.equals(input1.toUpperCase().equals("Q"))) {
            return inputs;
        }
        this.inputs[0] = input1;
        return inputs;

    }

    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0].toUpperCase()) {
            case "D":
//                DropCargoView d = new DropCargoView();
                DropView d = new DropView();
                d.display();
                break;

            case "R":
                inputs[0] = "Q";
                break;

            default:
                System.out.println("Invalid Menu Item");

        }

        return true;
    }

    

    private void listInventory() {
        Plunder p = new Plunder();
        ArrayList<InventoryItem> items = InventoryControl.sortInventory(p.getCurrentGame().getInventory());
//        for (InventoryItem item : items) {
//            System.out.println(item.getTypeAbr() + "  -  "
//                    + item.getInventoryType() + "  -  "
//                    + item.getQuantityInStock() + " units  -  worth "
//                    + item.getValue() + "  -  "
//                    + item.getWeight() + " tonnes");
//        }
        
        String format = "%-3s %-20.20s %-10s %-10s %-10s % -15s %-15s %n";
        System.out.format(format, "Abr", "Name", "Amount", "Weight", "Value", "Total Weight", "Total Value");
        System.out.println("=====================================================");
        format = " %-3s %-20.20s %-10d %-10d %-10d %-10d %-10d %n";
        for (int i = 0; i < items.size(); i++) {
            System.out.format(format, items.get(i).getTypeAbr(), items.get(i).getInventoryType(), 
                    items.get(i).getQuantityInStock(), items.get(i).getWeight(), items.get(i).getValue(),
                    items.get(i).getQuantityInStock() * items.get(i).getWeight(),
                    items.get(i).getQuantityInStock() * items.get(i).getValue());
        }
    }

}

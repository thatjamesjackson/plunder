/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.GameControl;
import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.Ship;
import exceptions.GameControlException;
import exceptions.InventoryControlException;
import java.util.ArrayList;
import plunder.Plunder;

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
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
       
        listInventory();

        this.promptMessage
                = "\n  Our ship be sitting at " + weight + " tonnes\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "  What do ya want to do?\n"
                + "    D - Drop Cargo\n"
                + "    P - Print report \n"
                + "    Q - Return to navigation\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
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
                listInventory();
                DropView d = new DropView();
                d.display();
                break;
                
            case "P":
                PrintInventoryView printMe = new PrintInventoryView();
                printMe.display();
                break;

            case "Q":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return false;

    }

    public void listInventory() {
        Plunder p = new Plunder();
        ArrayList<InventoryItem> items = InventoryControl.sortInventory(p.getCurrentGame().getInventory());
//        for (InventoryItem item : items) {
//            this.console.println(item.getTypeAbr() + "  -  "
//                    + item.getInventoryType() + "  -  "
//                    + item.getQuantityInStock() + " units  -  worth "
//                    + item.getValue() + "  -  "
//                    + item.getWeight() + " tonnes");
//        }

        String format = "%-6s %-15.20s %-10s %-10s %-10s %-15s %-15s %n";
        this.console.format(format, "Abr", "Name", "Amount", "Weight", "Value", "Total Weight", "Total Value");
        for (int i = 0; i < 83; i++) {
            this.console.print("=");
        }
        this.console.print("\n");
        format = "%-6s %-15.20s %-10d %-10.00f %-10.00f %-15.00f %-15.00f %n";
        for (int i = 0; i < items.size(); i++) {
            this.console.format(format,
                    items.get(i).getTypeAbr(),
                    items.get(i).getInventoryType(),
                    items.get(i).getQuantityInStock(),
                    items.get(i).getWeight(),
                    items.get(i).getValue(),
                    items.get(i).getQuantityInStock() * items.get(i).getWeight(),
                    items.get(i).getQuantityInStock() * items.get(i).getValue());
        }
    }
   
}

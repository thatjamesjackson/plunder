/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.GameControl;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.InventoryItem;
import exceptions.GameControlException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class PrintInventoryView extends View {

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];

        //instructions to save game
        this.console.println("Where do you want to save the file? \n Input Q to quit to main menu");

        //get input
        String input = this.getInput("Enter location: ");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String filePath = inputs[0];

        if (filePath.equals("Q") || filePath.equals("q")) {
            this.console.println("Quitting to main menu");
            return true;
        }
        
        try {
            this.printInventory(filePath);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

        return true;
    }

    private void printInventory(String filePath) throws GameControlException {

        ArrayList<InventoryItem> items = Plunder.getCurrentGame().getPlayer().getShip().getInventory();

        if (items == null || filePath.length() < 1 || items.size() < 1) {
            throw new GameControlException("Error printing report");
        }

        try (PrintWriter out = new PrintWriter(filePath)) {

            out.println("\n Inventory Report \n");
            String format = "%-6s %-15.20s %-10s %-10s %-10s %-15s %-15s %n";
            out.printf(format, "Abr", "Name", "Amount", "Weight", "Value", "Total Weight", "Total Value");
            for (int i = 0; i < 83; i++) {
                out.print("=");
            }
            out.print("\n");
            format = "%-6s %-15.20s %-10d %-10.00f %-10.00f %-15.00f %-15.00f %n";
            for (int i = 0; i < items.size(); i++) {
                out.printf(format,
                        items.get(i).getTypeAbr(),
                        items.get(i).getInventoryType(),
                        items.get(i).getQuantityInStock(),
                        items.get(i).getWeight(),
                        items.get(i).getValue(),
                        items.get(i).getQuantityInStock() * items.get(i).getWeight(),
                        items.get(i).getQuantityInStock() * items.get(i).getValue());
            }
        } catch (IOException ex) {
            throw new GameControlException(ex.getMessage());
        }

        this.console.println("Your report was saved to: " + filePath);

    }

}

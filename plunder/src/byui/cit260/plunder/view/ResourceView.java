/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.ResourceScene;
import byui.cit260.plunder.model.Ship;
import exceptions.InventoryControlException;
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class ResourceView extends View {

    @Override
    public String[] getInputs() {

        // display menu
        Actor actor = Plunder.getPlayer().getActor();
        int playerX = (int) actor.getCoordinates().getX();
        int playerY = (int) actor.getCoordinates().getY();
        this.console.println(Plunder.getCurrentGame().getMap().getLocation()[playerY][playerX].getScene().getDescription());
        this.console.println(
                  "    H - Attempt to harvest here\n"
                + "    Q - Return to previous menu\n");
        //declare new
        String[] inputs = new String[1];

        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0]) {
            case "H":
                harvest();
                break;

            case "Q":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return false;
    }

    private void harvest() {
        Actor actor = Plunder.getPlayer().getActor();
        int playerX = (int) actor.getCoordinates().getX();
        int playerY = (int) actor.getCoordinates().getY();
        ResourceScene scene = (ResourceScene) Plunder.getCurrentGame().getMap().getLocation()[playerY][playerX].getScene();
        InventoryItem resource = scene.getResource();
        Ship ship = Plunder.getPlayer().getShip();
        ArrayList inventory = ship.getInventory();
        Random random = new Random();
        int gain = random.nextInt(30);
        boolean inInventory = false;
        for (Object curItem : inventory) {
            InventoryItem item = (InventoryItem) curItem;
            if (item.getInventoryType().equals(resource.getInventoryType())) {
                item.setQuantityInStock(item.getQuantityInStock() + gain);
                inInventory = true;
            }
        }
        if (!inInventory) {
            resource.setQuantityInStock(gain);
            inventory.add(resource);
        }
        try {
            this.console.println("Ye gathered " + gain + " units of " + resource.getInventoryType()
                    + "\n Yer ship be sittin at " + InventoryControl.calculateWeight(ship) + "/" + ship.getCarryWeight() + " tonnes");
        } catch (InventoryControlException ex) {
            Logger.getLogger(ResourceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

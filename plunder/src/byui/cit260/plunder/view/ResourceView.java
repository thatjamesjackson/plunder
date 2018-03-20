/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.ResourceScene;
import byui.cit260.plunder.model.Ship;
import java.util.ArrayList;

/**
 *
 * @author James
 */
public class ResourceView extends View {

    @Override
    public String[] getInputs() {
        //this will be replaced by an import eventually 
        ResourceScene scene = new ResourceScene();

        //declare new string array
        String[] inputs = new String[1];
        System.out.println(scene.getDescription());
        inputs[0] = this.getInput("G - Gather Resources\n"
                + "L - Leave Resources");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        //this part needs to be imported eventually

        ResourceScene scene = new ResourceScene();
        Ship playerShip = new Ship();
        switch (inputs[0]) {

            case "L":
                return true;
            case "G":
                boolean inInventory = false;
                //find the same item and add the two quantiies together
                for (int i = 0; i < playerShip.getInventory().size(); i++) {
                   ArrayList<InventoryItem> items = playerShip.getInventory();
                   InventoryItem item = items.get(i);
                   
                    if (item.getInventoryType().equals(scene.getResource().getInventoryType())) {
                        item.setQuantityInStock(item.getQuantityInStock() + scene.getResource().getQuantityInStock());
                        inInventory = true;
                    }
                }
                //if it is not in the inventory add it
                if (!inInventory) {
                   playerShip.getInventory().add(scene.getResource());
                }

                return true;
            default:
                System.out.println("Invalid Menu Item");
                return false;
                    

        }
    }

}

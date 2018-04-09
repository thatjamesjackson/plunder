/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.InventoryItem;

/**
 *
 * @author abigailking
 */
public class DropView extends View {
    
    @Override
    public String[] getInputs() {

        //get inputs from user
//        NPC[] crew = getCrew();
//        getCrewMenu(crew);
        InventoryView checkInventory = new InventoryView();
        
        String[] inputs = new String[1];
        inputs[0] = this.getInput(
                "        Here be yer inventory. \n"
                // checkInventory.display();
                + "================================ \n"
                + "        Do ye want to:\n"
                + "   A  - Drop all of an item\n"
                + "   H  - Drop half of an item\n"
                + "   P  - Drop part of an item\n"
                + "   Q  - Quit \n");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        // NPC[] crew = getCrew();
        // getCrewMenu(crew);
        InventoryItem yerInventory = new InventoryItem();

        inputs[0] = inputs[0].toUpperCase().trim();
        switch (inputs[0]) {
            case "A":
                allDrop(yerInventory);
                break;

            case "H":
                halfDrop(yerInventory);
                break;
                
            case "P":
                partDrop(yerInventory);

            default:
                System.out.println("Invalid Menu Item");

        }

        return true;
    }

    private void allDrop(InventoryItem yerInventory) {
        System.out.println("Which item do ye want to get all rid of?");
    }

    private void halfDrop(InventoryItem yerInventory) {
        System.out.println("Which item do ye want to get rid of half yer portion?");
    }

    private void partDrop(InventoryItem yerInventory) {
        System.out.println("What item do ye want to drop a certain part of?");
        
//        System.out.println("How much of " + inventoryitem + " do ye want to drop?");
    }
    
}

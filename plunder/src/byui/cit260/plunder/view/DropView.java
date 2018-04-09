/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.InventoryItem;
import java.util.ArrayList;
import plunder.Plunder;

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
                + "   P  - Drop part of an item\n"
                + "   Q  - Quit \n");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        // NPC[] crew = getCrew();
        // getCrewMenu(crew);
        ArrayList<InventoryItem> yerInventory = Plunder.getCurrentGame().getInventory();
        inputs[0] = inputs[0].toUpperCase().trim();
        
        
        switch (inputs[0]) {
            case "A":
                allDrop(yerInventory);
                break;

            case "P":
                partDrop(yerInventory);

            default:
                System.out.println("Invalid Menu Item");

        }

        return true;
    }

    private void allDrop(ArrayList<InventoryItem> inventory) {
        InventoryView inv = new InventoryView();
        inv.listInventory();
        String input = getInput("Which item do ye want to get all rid of?");
        for(InventoryItem curItem: inventory){
            if(curItem.getTypeAbr().equals(input)){
            curItem.setQuanti
            }
            
        }
    }



    private void partDrop(ArrayList<InventoryItem> yerInventory) {
        System.out.println("What item do ye want to drop a certain part of?");
        InventoryView inv = new InventoryView();
        inv.listInventory();
        
        
//        System.out.println("How much of " + inventoryitem + " do ye want to drop?");
    }
    
}

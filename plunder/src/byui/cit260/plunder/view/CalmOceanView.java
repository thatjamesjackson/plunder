/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

/**
 *
 * @author abigailking
 */
public class CalmOceanView extends View{
    

    @Override
    public String[] getInputs() {
        
        // display menu
        System.out.println("  H - Attempt to harvest here"
                + "  E - Keep exploring");
        //declare new
        String [] inputs = new String[1];
        
        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs [0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        
        switch (inputs[0]) {
            case "H":
                harvest();
                break;

            case "E":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid option");

        }
        return false; 
    }

    private void harvest() {
        System.out.println("You harvested");
    }
}

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
public class RoughOceanView extends View{
    

    @Override
    public String[] getInputs() {
        
        // display menu
        this.console.println("  H - Attempt to harvest here"
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
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return false; 
    }

    private void harvest() {
        this.console.println("You harvested");
    }
}

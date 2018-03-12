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
public class ExploreView extends View {
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        
        //Display the instructions for this view
        System.out.println("\n This is a demo view with two inputs");
        
        // get the first input and assign to the first poistion in the inputs array
        String value = this.getInput("\n Enter the base of the triangle: ");
        if (value.trim().toUpperCase(),equals("Q")) {
            return inputs;
        }
        
        //get the second input and assing to the next position in the inputs array
        value = this.getInput("\n Enter the height of the triangle: ");
        if (value.trim().toUpperCase().equals("Q")) {
            inputs[0] = "Q";
            return inputs;
        }
        
    }
    
    @Override
    public boolean doAction(String[] inputs) {
    
        //get the two inputs and concert them to a doulbe type
        double base = Double.parseDouble(inputs[0]);
        double height = Double.parseDouble(inputs[1]);
        
        //call control method
        double area = GameControl.calcAreaOfTriangle(base, height);
        
        if (area < 0) {
            System.out.println("Invalid base of height");
            return false;
        }
        
        System.out.println("")
        return true;
    }
}

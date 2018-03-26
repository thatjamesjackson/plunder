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
public class WinGameView extends View {

    public void display() { 
        
    }
    
    @Override
    public String[] getInputs() {
        // display menu
        System.out.println(" Are ya gonna take the treasure for yerself?");
        //declare new
        String [] inputs = new String[1];
        
        // retrieve input from user
        String input = this.getInput("Yea or Nae?");
        inputs [0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        // do things
    }
    
}

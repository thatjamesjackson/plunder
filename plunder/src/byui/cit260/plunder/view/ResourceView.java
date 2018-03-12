/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.ResourceScene;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class ResourceView extends View {

    @Override
    public String[] getInputs() {
        
        //declare new string array
        String[] inputs = new String[1];
        inputs[0] = this.getInput("Select a menu item");
        return inputs;}

    @Override
    public boolean doAction(String[] inputs) {
    ResourceScene scene = new ResourceScene();
    
    return true;
    }
    
}

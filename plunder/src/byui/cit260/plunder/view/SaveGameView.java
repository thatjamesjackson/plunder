/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.GameControl;
import byui.cit260.plunder.model.Game;
import exceptions.GameControlException;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class SaveGameView extends View {

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];

        //instructions to save game
        this.console.println("");
        
        //get input
        String input = this.getInput("Select a menu item");
        inputs[0] = input;
        return inputs;

    }

    @Override
    public boolean doAction(String[] inputs) {

        String filePath = inputs[0];
        Game playing = Plunder.getCurrentGame();
        
        try {
            GameControl.saveGame(playing, filePath);
        } catch (GameControlException ex){
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        this.console.println("Your file was saved to: " + filePath);
        
        return true;
    }

}

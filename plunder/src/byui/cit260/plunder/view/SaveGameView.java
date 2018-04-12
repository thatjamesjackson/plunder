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
        this.console.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "Where do you want to save the file? \n (Input Q to quit to main menu)");
        
        //get input
        String input = this.getInput("Enter location: ");
        inputs[0] = input;
        return inputs;

    }

    @Override
    public boolean doAction(String[] inputs) {
        
//            filePath = get first value in inputs array
//            game = get the currentGame in the main class
//            try
//            call the saveGame(game)control method
//            catch GameControlException
//            Print error passed with the exception
//            return false to repeat the view
//            endTry
//            Print a success message indicating where the
//            file was saved
//            return true to end the view


        String filePath = inputs[0];
        Game playing = Plunder.getCurrentGame();
        if (filePath.equals("Q") || filePath.equals("q")){
            this.console.println("Quitting to main menu");
            return true;
        }
        playing.toString();
        try {
            GameControl.saveGame(playing, filePath);
        } catch (GameControlException ex){
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
        
        this.console.println("Your file was saved to: " + filePath);
        
        return true;
    }

}

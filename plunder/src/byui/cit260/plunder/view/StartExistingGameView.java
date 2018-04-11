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
 * @author James
 */
class StartExistingGameView extends View{


    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        //instructions to save game
        this.console.println("Where is the saved file you want to restart?");
        
        //get input
        String input = this.getInput("Enter location: ");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
//        filePath = get first value in inputs array
//        try
//        call the getGame() control method
//        catch GameControlException
//        Print error passed with the exception
//        return false to repeat the view
//        endTry
//        gameMenuView = Create a new GameMenuView object
//        display the gameMenuView
//        return true to end the view

        String filePath = inputs[0];
        Game playing = Plunder.getCurrentGame();
        
        try {
            GameControl.getGame(playing, filePath);
        } catch (GameControlException ex){
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }
        
        GameMenuView showGame = new GameMenuView();
        showGame.display();
        
        return true;
    }
    
}

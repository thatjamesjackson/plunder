/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.GameControl;
import exceptions.GameControlException;
import exceptions.MapControlException;
import java.util.logging.Level;
import java.util.logging.Logger;

import plunder.Plunder;

/**
 *
 * @author James
 */
public class MainMenuView extends View {

    @Override
    public String[] getInputs() {
        //declare new
        String[] inputs = new String[1];

        //show menu options
        this.console.println("  N - New game\n"
                + "  L - Load Game\n"
                + "  H - Help\n"
                + "  Q - Quit Program");

        inputs[0] = this.getInput("Select a menu item: ");

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        //switch for the menu
        switch (inputs[0]) {

            case "N":
                startNewGame();
                break;

            case "L":
                restartGame();
                break;

            case "H":
                getHelp();
                break;

            case "Q":
                //this is the only way to exit this loop
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return false;
    }

    private void startNewGame() {
        try {
            try {
                //Create a new Game
                GameControl.createNewGame(Plunder.getPlayer());
            } catch (GameControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } catch (MapControlException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            ErrorView.display(this.getClass().getName(), "Error making game");
        }
        GameMenuView gameMenuView = new GameMenuView();

        gameMenuView.display();
    }

    private void restartGame() {
        //restart the game
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.display();
    }

    private void getHelp() {
        //help menu
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

}

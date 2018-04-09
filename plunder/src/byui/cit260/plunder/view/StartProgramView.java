/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import byui.cit260.plunder.control.GameControl;
import byui.cit260.plunder.model.Player;
import exceptions.GameControlException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class StartProgramView extends View {

    public StartProgramView() {
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        System.out.println(
                  "**********************************************\n"
                + "**********************************************\n"
                + "****                                      ****\n"
                + "****                                      ****\n"
                + "****                                      ****\n"
                + "****           Welcome to the             ****\n"
                + "****         waters of Paradise!          ****\n"
                + "****   In this role playing pirate game,  ****\n"
                + "**** ye be the captain of this ship here. ****\n"
                + "****   Set sails and search for plunder.  ****\n"
                + "**** There be talk of a near off treasure ****\n"
                + "****                                      ****\n"
                + "****                                      ****\n"
                + "****                                      ****\n"
                + "**********************************************\n"
                + "**********************************************");
        String input = this.getInput("Enter the player's name");
        inputs[0] = input;
        return inputs;

    }

    @Override
    public boolean doAction(String[] inputs) {
//        System.out.println("DO ACTION CALLED");
//        System.out.println("\tinputs = " + inputs[0]);
        Player player = null;
        try {
            player = GameControl.savePlayer(inputs[0]);
        } catch (GameControlException ex) {
            System.out.println(ex.getMessage());
        }

        if (player == null) {
            System.out.println("Could not create the player "
                    + "\t Enter a different name");
            return false;
        }

        System.out.println("=============================================================\n"
                         + "      Welcome " + inputs[0] + ", to the seas of Paradise\n"
                         + "=============================================================\n");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
        return true;
    }
}

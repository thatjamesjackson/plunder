/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.GameControl;
import byui.cit260.plunder.model.Player;
import java.util.Scanner;

/**
 *
 * @author abigailking
 */
public class HelpMenuView {
    public void display() { 
        boolean endView = false; 
        
        do{
             System.out.println("  G - What is the goal of the game?\n" +
                                "  M - How to move\n" +
                                "  C – How to engage in combat\n" +
                                "  T – How to trade \n" +
                                "  S - Save game\n" +
                                "  R - Restart game\n" +
                                "  P - Pause game\n" +
                                "  Q - Quit game");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a valid option");
                continue;
            }
            

            
        endView = doAction(first);
    } while(endView != true);
}

    public void displayHelpMenuView() {

    }

    public HelpMenuView() {
        
    }

    private String[] getInputs() {
//        System.out.println("GET INPUTS CALLED");
//        String[] inputs = new String[1];
//        inputs[0] = "testInput";

        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }
    
    private boolean doAction(String[] inputs) {
//        System.out.println("DO ACTION CALLED");
//        System.out.println("\tinputs = " + inputs[0]);
        System.out.println("DO ACTION CALLED");
     switch (input) {
                case "N":
                    startNewGame();
                    break;

                case "R":
                    restartGame();
                    break;

                case "H":
                   getHelp();
                    break;

                case "Q":
                    return true;
                default:
                        System.out.println("Invalid Menu Item");
                    
        }
     return true;
    }
}

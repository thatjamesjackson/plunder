/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import byui.cit260.plunder.control.GameControl;
import java.util.Scanner;
import plunder.Plunder;
/**
 *
 * @author James
 */
public class MainMenuView {
    
    
    public void display(){
    boolean endView = false; 
        
        do{
             System.out.println("  N - New game\n"
                    + "  R - Restart Game\n"
                    + "  H - Help\n"
                    + "  Q - Quit Program");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }
            

            
        endView = doAction(first);
    } while(endView != true);
    }


    private String[] getInputs() {
        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }

    private boolean doAction(String input) {
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
     return false;
    }

    private void startNewGame() {
    //Create a new Game 
    GameControl.createNewGame(Plunder.getPlayer());
    GameMenuView gameMenuView =  new GameMenuView();
    gameMenuView.display();
    }

    private void restartGame() {
       StartExistingGameView startExistingGameView = new StartExistingGameView();
       startExistingGameView.display();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
}

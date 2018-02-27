/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import java.util.Scanner;
/**
 *
 * @author James
 */
public class MainMenuView {
    
    
    public void display(){
    boolean endView = false; 
        
        do{
             System.out.println("N - New game\n"
                    + "L - Load Game\n"
                    + "H - Help\n"
                    + "Q - Quit Program");
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
       System.out.println("NEW GAME");
    }

    private void restartGame() {
       System.out.println("RESTART GAME");
    }

    private void getHelp() {
        System.out.println("GET HELP");
    }
}

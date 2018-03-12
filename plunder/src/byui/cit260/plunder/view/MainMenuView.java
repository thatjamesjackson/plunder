/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import byui.cit260.plunder.control.GameControl;
import byui.cit260.plunder.model.NPC;
import byui.cit260.plunder.model.Ship;
import java.util.Scanner;
import plunder.Plunder;
/**
 *
 * @author James
 */
public class MainMenuView extends View {
    
    @Override
    public String[] getInputs() {
        //declare new string
        String [] inputs = new String[1];

        //show menu options
        System.out.println("  N - New game\n"
                    + "  R - Restart Game\n"
                    + "  H - Help\n"
                    + "  Q - Quit Program");
        
        inputs [0] = input;
        return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        //switch for the menu
        switch (input) {
            case "C":
                CombatView combatView = new CombatView();
                Ship shipOne = new Ship();
                shipOne.setName("Salty Dog");
                shipOne.setShipAttack(50);
                shipOne.setCarryWeight(500);
                shipOne.setArmor(50);
                shipOne.setShipRepair(10);
                shipOne.setShipHealth(100);
                shipOne.setShipMaxHealth(100);
                
                Ship shipTwo = new Ship();
                shipTwo.setName("Man of War");
                shipTwo.setShipAttack(50);
                shipTwo.setCarryWeight(500);
                shipTwo.setArmor(50);
                shipTwo.setShipRepair(10);
                shipTwo.setShipHealth(100);
                
                
                combatView.display(shipOne, shipTwo);
                break;
                            
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
                //this is the only way to exit this loop
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
        //restart the game
       StartExistingGameView startExistingGameView = new StartExistingGameView();
       startExistingGameView.display();
    }

    private void getHelp() {
        //help menu
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    @Override
    public boolean doAction(String[] inputs) {
        //switch for the menu
        switch (input) {
            case "C":
                CombatView combatView = new CombatView();
                Ship shipOne = new Ship();
                shipOne.setName("Salty Dog");
                shipOne.setShipAttack(50);
                shipOne.setCarryWeight(500);
                shipOne.setArmor(50);
                shipOne.setShipRepair(10);
                shipOne.setShipHealth(100);
                shipOne.setShipMaxHealth(100);
                
                Ship shipTwo = new Ship();
                shipTwo.setName("Man of War");
                shipTwo.setShipAttack(50);
                shipTwo.setCarryWeight(500);
                shipTwo.setArmor(50);
                shipTwo.setShipRepair(10);
                shipTwo.setShipHealth(100);
                
                
                combatView.display(shipOne, shipTwo);
                break;
                            
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
                //this is the only way to exit this loop
                return true;
            default:
                System.out.println("Invalid Menu Item");

        }
     return false;
    }
    
}

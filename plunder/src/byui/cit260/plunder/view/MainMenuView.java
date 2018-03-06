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
public class MainMenuView {
    
    
    public void display(){
        //display the menu
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
        //get inputs from user
        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }

    private boolean doAction(String input) {
        //switch for the menu
        switch (input) {
            case "C":
                CombatView combatView = new CombatView();
                Ship shipOne = new Ship();
                shipOne.setName("Salty Dog");
                shipOne.setShipAttack(100);
                shipOne.setCarryWeight(500);
                shipOne.setArmor(50);
                shipOne.setShipRepair(10);
                shipOne.setShipHealth(100);
                
                Ship shipTwo = new Ship();
                shipTwo.setName("Man of War");
                shipTwo.setShipAttack(100);
                shipTwo.setCarryWeight(500);
                shipTwo.setArmor(50);
                shipTwo.setShipRepair(10);
                shipTwo.setShipHealth(100);
                
                combatView.display(shipOne, shipTwo);
                break;
                
            case "P": 
                NPC npc1 = new NPC();
                npc1.setIsCrew(true);
                npc1.setCrewAttack(100);
                npc1.setCrewRepair(100);
                npc1.setJob("Gunner");
                npc1.setName("Bob");
                npc1.setTalk("I ain't got nothin");
                    
                NPC npc2 = new NPC();
                npc2.setIsCrew(false);
                npc2.setCrewAttack(100);
                npc2.setCrewRepair(100);
                npc2.setJob("Gunner");
                npc2.setName("NOT CREW");
                    
                NPC npc3 = new NPC();
                npc3.setIsCrew(true);
                npc3.setCrewAttack(100);
                npc3.setCrewRepair(100);
                npc3.setJob("Carpenter");
                npc3.setName("Steven");
                npc3.setTalk("I ain't got nothin neither");
                
                NPC[] arrayNPC = {npc1, npc2, npc3};
                CrewView crewView = new CrewView();
                crewView.display(arrayNPC);
            
                
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
}

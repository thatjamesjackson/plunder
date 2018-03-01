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
public class GameMenuView {

    public void display(){
        boolean endView = false; 
        
        do {
            System.out.println("+--+--+--+--+--+\n"
                             + "|  |  |  |  |  |\n"
                             + "+--+--+--+--+--+\n"
                             + "|  |  |  |  |  |\n"
                             + "+--+--+--+--+--+\n"
                             + "|  |  |  |  |  |\n"
                             + "+--+--+--+--+--+\n"
                             + "|  |  |  |  |  |\n"
                             + "+--+--+--+--+--+\n"
                             + "|  |  |  |  |  |\n"
                             + "+--+--+--+--+--+\n"
                             + "\n"
                             + "  N - Travel North\n"
                             + "  W - Travel West\n"
                             + "  E - Travel East\n"
                             + "  S - Travel South\n"
                             + "  I - Check Inventory\n"
                             + "  C - Check Crew\n"
                             + "  B - Check Ship\n"
                             + "  P - Explore\n"
                             + "  H - Help\n"
                             + "  V - Save\n"
                             + "  X - Exit");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }

            endView = doAction(first);
        } while (endView != true);
    }

    public GameMenuView() {

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
                travelNorth();
                break;

            case "W":
                travelWest();
                break;

            case "E":
                travelEast();
                break;

            case "S":
                travelSouth();
                break;

            case "I":
                checkInventory();
                break;

            case "C":
                checkCrew();
                break;

            case "B":
                checkShip();
                break;

            case "P":
                doExplore();
                break;

            case "H":
                loadHelp();
                break;

            case "V":
                saveGame();
                break;

            case "X":
                return true;

            default:
                System.out.println("Invalid Menu Item");

        }
        return false;
    }

    private void travelNorth() {
        
    }

    private void travelWest() {
        
    }

    private void travelEast() {
        
    }

    private void travelSouth() {
        
    }

    private void checkInventory() {
        
    }

    private void checkCrew() {
        
    }

    private void checkShip() {
        
    }

    private void doExplore() {
        
    }
    
    private void loadHelp() {
        HelpMenuView gameHelp = new HelpMenuView();
        
        gameHelp.displayHelpMenuView();
    }

    private void saveGame() {
        
    }

}

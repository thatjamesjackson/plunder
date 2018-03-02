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
        System.out.println("You are traveling North");
    }

    private void travelWest() {
        System.out.println("You are traveling West");
    }

    private void travelEast() {
        System.out.println("You are traveling East");
    }

    private void travelSouth() {
        System.out.println("You are traveling South");
    }

    private void checkInventory() {
        System.out.println("Let's see what we have here on the boat");
        
        InventoryView checkInventory = new InventoryView();
        checkInventory.display();
    }

    private void checkCrew() {
        System.out.println("Attention! Sound off");
    }

    private void checkShip() {
        System.out.println("Our ship looks yar");
    }

    private void doExplore() {
        System.out.println("Here be water");
    }
    
    private void loadHelp() {
        HelpMenuView gameHelp = new HelpMenuView();
        
        gameHelp.displayHelpMenuView();
    }

    private void saveGame() {
        
    }

}

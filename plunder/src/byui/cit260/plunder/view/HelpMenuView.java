/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;


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
                                "  Q - Quit help menu");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
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

        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }
    
    private boolean doAction(String input) {
//        System.out.println("DO ACTION CALLED");
//        System.out.println("\tinputs = " + inputs[0]);
        System.out.println("DO ACTION CALLED");
     switch(input){
         case "G":
               System.out.println("game goal");
             break;

         case "M":
             System.out.println("how to move");
             break;

         case "C":
             System.out.println("how to combat");
             break;

         case "T":
             System.out.println("how to trade");
             break;

         case "S":
             System.out.println("save game");
             break;

         case "R":
             System.out.println("restart game");
             break;

         case "Q":
             return true;
             
         default:
             System.out.println("Invalid Menu Item");
                    
        }
     return false;
    }
}

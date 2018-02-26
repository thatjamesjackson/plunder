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
 * @author James
 */
public class StartProgramView {
    public void display() { 
        boolean endView = false; 
        
        do{
            String[] inputs = getInputs() ;
            String first = inputs[0].toUpperCase();

            if (first.equals('Q')|| inputs.length < 1)
            return;
        endView = doAction(inputs);
    } while(endView != true);
}

    public void displayStartProgramView() {

    }

    public StartProgramView() {
    }

    private String[] getInputs() {
//        System.out.println("GET INPUTS CALLED");
//        String[] inputs = new String[1];
//        inputs[0] = "testInput";

        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
                    
        System.out.println("****************************************\n" +
"****************************************\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                   Welcome to the                      ****\n" +
"****                 waters of Paradise!                  ****\n" +
"****        In this role playing pirate game,     ****\n" +
"****     ye be the captain of this ship here.   ****\n" +
"****        Set sails and search for plunder.     ****\n" +
"****    There be talk of a near off treasure    ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****                                                                      ****\n" +
"****************************************\n" +
"****************************************");
        boolean valid = false;
        while (valid == false){
            System.out.println("Enter the player's name");
            
            String name = scan.nextLine();
            if (name.equals(" ") ) {
                System.out.println("invalid value entered");
                continue;
            }
            name = name.trim();
            String nameUpper = name.toUpperCase();
            
            if (name.length() < 2 && nameUpper == "Q"){
                System.out.println("Ye must enter a longer name");
                continue;
            }
            
            inputs[0] = name;
            valid = true;
       }
    return inputs;
            }
    
    private boolean doAction(String[] inputs) {
//        System.out.println("DO ACTION CALLED");
//        System.out.println("\tinputs = " + inputs[0]);
        Player player = GameControl.savePlayer(inputs[0]);
        
        if (player == null) {
            System.out.println("Could not create the player "
                    + "\t Enter a different name");
            return false;
        }
        
        System.out.println("Welcome " + inputs[0] + " to the seas of Paradise");
        return true;
    }
}

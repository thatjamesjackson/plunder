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
public abstract class View implements ViewInterface {

    public View() {
    }
    
    @Override
    public void display() {
        //display the menu
        boolean endView = false;

        do {
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase().trim();
            if (1 > first.length()) {
                System.out.println("Please enter a menu item");
                continue;
            }
            
            endView = doAction(inputs);
        } while (endView != true);
    }
    
    @Override
    public String getInput(String promptMessage) {
        System.out.println(promptMessage);
        //get inputs from user
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import plunder.Plunder;

/**
 *
 * @author James
 */
public abstract class View implements ViewInterface {

    
    protected final BufferedReader keyboard = Plunder.getInFile();
    protected final PrintWriter console = Plunder.getOutFile();
    
    public View() {
    }

    @Override
    public void display() {
        //display the menu
        boolean endView = false;

        do {
            String[] inputs = getInputs();
            inputs[0] = inputs[0].toUpperCase().trim();
            if (1 > inputs[0].length()) {
                this.console.println("Please enter a menu item");
                continue;
            }
            endView = doAction(inputs);
        } while (endView != true);
    }

    @Override
    public String getInput(String promptMessage) {
        this.console.println(promptMessage);

        boolean valid = false;
        String selection = null;
        
        try{
            //while a valid name has not been retrieved
            while(!valid) {
                
                // get the value entered from the keyboard
                selection = this.keyboard.readLine();
                selection = selection.trim();
                
                if (selection.length() < 1){ // blank value entered
                    this.console.println("You must enter a value.");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
             ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        
        return selection;
    }

}

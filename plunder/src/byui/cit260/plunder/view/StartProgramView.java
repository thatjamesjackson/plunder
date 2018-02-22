/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

/**
 *
 * @author James
 */
public class StartProgramView {
    public void display() { 
 boolean endView = false; 
 do{
String input = getInputs() ;
if (input.charAt(0) == 'Q' || input.charAt(0)=='q' || input.length() == 0)
 return;
endView = doAction(inputs);
    } while(endView != true);
}

    public void displayStartProgramView() {

    }

    public StartProgramView() {
    }
}

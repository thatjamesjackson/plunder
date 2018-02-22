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
String[] input = getInputs() ;
String first = input[0].toUpperCase();
if (first.equals('Q')|| input.length < 1)
 return;
endView = doAction(input);
    } while(endView != true);
}

    public void displayStartProgramView() {

    }

    public StartProgramView() {
    }
}

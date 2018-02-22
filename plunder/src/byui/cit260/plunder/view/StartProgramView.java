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
        System.out.println("GET INPUTS CALLED");
    String[] inputs = new String[1];
    inputs[0] = "testInput";
    return inputs;
            }
    private boolean doAction(String[] inputs) {
        System.out.println("DO ACTION CALLED");
        System.out.println("\tinputs = " + inputs[0]);
        return true;
    }
}

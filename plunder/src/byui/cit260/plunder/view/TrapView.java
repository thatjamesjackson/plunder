/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

/**
 *
 * @author abigailking
 */
public class TrapView extends View {

    @Override
    public String[] getInputs() {

        // display menu
        this.console.println(
                "     The majestic shrine of The Siren stands before you. \n "
                + "           There be talk of treasure inside. \n"
                + "=======================================================\n"
                + "                Do ye want to:\n"
                + "                E  -  Enter the shrine\n"
                + "                S  -  Leave to ship\n"
                + "                C  -  Check yer crew\n");
        //declare new
        String[] inputs = new String[1];

        // retrieve input from user
        String input = this.getInput("Make yer choice:");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        // declare needed variables for loop
        boolean win = false;
        
        
        switch (inputs[0]) {
                case "E":
                    this.console.println("You and yer crew enter the temple. Don't forget, \n"
                            + "yer crew may know more than ye do about this here temple.\n\n");
                    
                    TrapView2 moveOn = new TrapView2();
                    moveOn.display();
                    break;

                case "S":
                    return true;

                case "C":
                    CrewTalkView talkTo = new CrewTalkView();
                    talkTo.display();
                    return false;

                default:
                    ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

            }
        return true;

    }
}

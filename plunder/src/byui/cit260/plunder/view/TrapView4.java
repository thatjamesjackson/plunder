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
public class TrapView4 extends View {
// booby trap 3
    
    @Override
    public String[] getInputs() {
        // display menu
        this.console.println(
                      "  You see three curious doors each leads to a different fate.\n"
                    + "              One of the doors be made of pure gold, \n"
                    + "            the other of silver, and the last of wood.\n"
                    + "===============================================================\n"
                    + "                   C  -  Check yer crew\n"
                    + "                   G  -  Open the gold door\n"
                    + "                   S  -  Open the silver door\n"
                    + "                   W  -  Open the wood door\n");
        //declare new
        String[] inputs = new String[1];

        // retrieve input from user
        String input = this.getInput("Make yer choice:");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        boolean win = false;
        
        switch (inputs[0]) {
            case "C":
                CrewTalkView talkTo = new CrewTalkView();
                talkTo.display();
                return false;

            case "G":
                this.console.println(
                          "Behind the door you see your ship. You turn back around \n"
                        + "and you see the front of the Temple of the Siren. Rats.\n\n");
                TrapView moveBack = new TrapView();
                moveBack.display();
            
            case "S":
                this.console.println(
                          "       Wolfgang gets sick and starts to howls in pain.\n"
                        + "          Closing the door does nothing to help.\n"
                        + "You rush him back the ship, then return to the shrine entrance.\n\n");
                TrapView moveBack2 = new TrapView();
                moveBack2.display();
                // set wolfgang to 1
                
            case "W":
                win = true;
                WinGameView winner = new WinGameView();
                winner.display();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return true;
    }
    
}

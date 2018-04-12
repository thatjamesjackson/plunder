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
public class TrapView2 extends View {

    @Override
    public String[] getInputs() { 
        
        // display menu
        this.console.println(
                      "  You see a siren mural scrawled across the walls of the hallway. \n"
                    + "  As ye step inside and hear a click. \n"
                    + "  You've stepped on a pressure plate. Be careful with your next move. \n"
                    + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                    + "  Do ye want to:\n"
                    + "     C  -  Check yer crew\n"
                    + "     K  -  Keep walking, the click was probably nothing.\n"
                    + "     B  -  Take a step back off the pressure plate before continuing.\n");
        //declare new
        String[] inputs = new String[1];

        // retrieve input from user
        String input = this.getInput("Make yer choice:");
        inputs[0] = input;
        return inputs;
        
        
            
          
    }

    @Override
    public boolean doAction(String[] inputs) {
        
        switch (inputs[0]) {
            case "C":
                CrewTalkView talkTo = new CrewTalkView();
                talkTo.display();
                return false;

            case "K":
                this.console.println(
                    "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                      + "  Ouch! Ye got shot in the leg as a dart came shooting \\n"
                      + "  from the Siren's eyes in the mural beside ye. \n"
                      + "  You and yer crew return to the front of the shrine.\n\n");
                return true;

            case "B":
                this.console.println(
                     "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "  Ye made it safely. The Siren's stare follows ye \n"
                        + "  down the hall, but ye make it safely forward.\n\n");
                TrapView3 moveOn = new TrapView3();
                moveOn.display();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return true;
    }
    
}

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
        System.out.println(
                    "     You see a siren mural scrawled across the walls of the hallway. \n"
                    + "                As ye step inside and hear a click. \n"
                    + " You've stepped on a pressure plate. Be careful with your next move. \n"
                    + "======================================================================\n"
                            + "C  -  Check yer crew"
                            + "K  -  Keep walking, the click was probably nothing.\n"
                            + "B  -  Take a step back off the pressure plate before continuing.");
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
                CrewView talkTo = new CrewView();
                talkTo.display();
                break;

            case "K":
                System.out.println(
                        " Ouch! Ye got shot in the leg as a dart came shooting \n"
                      + "   from the Siren's eyes in the mural beside ye. \n"
                      + "  You and yer crew return to the front of the shrine.");
                TrapView moveBack = new TrapView();
                moveBack.display();

            case "B":
                System.out.println(
                          "Ye made it safely. The Siren's stare follows ye \n"
                        + " down the hall, but ye make it safely forward.");
                TrapView3 moveOn = new TrapView3();
                moveOn.display();

            default:
                System.out.println("Invalid Menu Item");

        }
        return true;
    }
    
}

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
public class TrapView3 extends View {

    @Override
    public String[] getInputs() {
        
        // display menu
        System.out.println(
                    "           The long hallway forks two ways. \n"
                    + "  To the right ye see a faint mysterious green glow. \n"
                    + "         To the left ye see a warm orange glow.\n"
                    + "======================================================\n"
                    + "               C  -  Check yer crew \n"
                    + "               L  -  Go left\n"
                    + "               R  -  Go right\n");
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

            case "L":
                System.out.println("Wise choice matey.\n\n");
                TrapView4 moveOn = new TrapView4();
                moveOn.display();

            case "R":
                System.out.println(
                          "    What's this? It seems that this way looped \n"
                        + "you and yer crew back to the entrance of the shrine. \n"
                        + " This here place must be cursed. Carefully now.\n\n");
                TrapView moveBack = new TrapView();
                moveBack.display();

            default:
                System.out.println("Invalid Menu Item\n");

        }
        return true;
    }
    
}

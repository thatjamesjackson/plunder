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
        System.out.println(
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
        CrewView talkTo = new CrewView();

        // loop through booby traps
        do { // enter booby trap and treasure
            System.out.println("Do ye want to: \n"
                    + "E  -  Enter the temple \n"
                    + "S  -  Leave to ship \n"
                    + "C  -  Check yer crew\n");
            String[] choice = getInputs();

            switch (choice[0]) {
                case "E":
                    System.out.println("You and yer crew enter the temple. Don't forget, \n"
                            + "yer crew may know more than ye do about this here temple.");
                    break;

                case "S":
                    return true;

                case "C":
                    talkTo.display();

                default:
                    System.out.println("Invalid Menu Item");

            }
            // booby trap 1
            System.out.println(
                    "     You see a siren mural scrawled across the walls of the hallway. \n"
                    + "                As ye step inside and hear a click. \n"
                    + " You've stepped on a pressure plate. Be careful with your next move. \n"
                    + "======================================================================\n"
                    + "T  -  Talk to yer crew"
                    + "K  -  Keep walking, the click was probably nothing.\n"
                    + "B  -  Take a step back off the pressure plate before continuing.");
            choice = getInputs();

            switch (choice[0]) {
                case "T":
                    talkTo.display();
                    break;

                case "K":
                    System.out.println("Ouch! Ye got shot in the leg as a dart came shooting \n"
                            + "from the Siren's eyes in the mural beside ye. \n"
                            + "You and yer crew return to the front of the temple.");
                    continue;

                case "B":
                    System.out.println("Ye made it safely. The Siren's stare follows ye \n"
                            + "down the hall, but ye make it safely forward.");
                    break;

                default:
                    System.out.println("Invalid Menu Item");

            }
            // booby trap 2
            System.out.println(
                    "           The long hallway forks two ways. \n"
                    + "  To the right ye see a faint mysterious green glow. \n"
                    + "         To the left ye see a warm orange glow."
                    + "======================================================\n"
                    + "               T  -  Talk to yer crew \n"
                    + "               L  -  Go left\n"
                    + "               R  -  Go right\n");
            choice = getInputs();

            switch (choice[0]) {
                case "T":
                    talkTo.display();
                    break;

                case "G":

                    break;

                case "R":
                    return true;

                default:
                    System.out.println("Invalid Menu Item");

            }
            // booby trap 3
            System.out.println(
                    "  You see three curious doors each leads to a different fate.\n"
                    + "              One of the doors be made of pure gold, \n"
                    + "            the other of silver, and the last of wood."
                    + "===============================================================\n"
                    + "                   T  -  Talk to yer crew\n"
                    + "                   G  -  Open the gold door\n"
                    + "                   S  -  Open the silver door\n"
                    + "                   W  -  Open the wood door");
            choice = getInputs();

            switch (choice[0]) {
                case "T":
                    talkTo.display();
                    break;

            case "G":
                System.out.println("Behind the door you see your ship. You turn \n"
                        + "back around and you see the front of the Temple of the Siren. Rats.");
                continue;
            
            case "S":
                System.out.println("Wolfgang gets sick and starts to screech in pain.\n"
                        + "Closing the door does nothing to help. You rush back to the ship.");
                continue;
                // set wolfgang to 1
                
            case "W":
                win = true;
                WinGameView winner = new WinGameView();
                winner.display();
                break;



                default:
                    System.out.println("Invalid Menu Item");

            }

        } while (win == false);
        return true;

    }
}

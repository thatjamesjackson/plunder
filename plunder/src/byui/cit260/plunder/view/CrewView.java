/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.CrewControl;
import static byui.cit260.plunder.control.CrewControl.getCrew;
import byui.cit260.plunder.model.NPC;
import exceptions.CrewControlException;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class CrewView extends View {

    @Override
    public String[] getInputs() {

        //get inputs from user
        NPC[] crew = getCrew();
        getCrewMenu(crew);
        String[] inputs = new String[1];
        inputs[0] = this.getInput("\nT - Talk to Crew"
                + "\nA - Assign Job"
                + "\nQ - Quit");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        NPC[] crew = getCrew();
        getCrewMenu(crew);
        inputs[0] = inputs[0].toUpperCase().trim();
        //switch for the menu
        switch (inputs[0]) {
            case "T":
                crewTalk(crew);
                break;
                
            case "A":
                assignJob(crew);
                break;
            case "Q":
                //this is the only way to exit this loop
                return true;

            default:
                this.console.println("Invalid Menu Item");
                        

        }
        return false;
    }

    private void crewTalk(NPC[] crew) {
        this.console.println("Which # Crew Member?\n");

        int inputInt;
        try {
            inputInt = (getInputCrewNumber(crew) - 1);
            this.console.println("=================================================================\n"
                    + crew[inputInt].getName() + ":\n"
                    + crew[inputInt].getTalk()
                    + "\n=================================================================\n");
        } catch (CrewControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

    private void assignJob(NPC[] crew) {

        try {
            // get the crew member

            int inputInt = (getInputCrewNumber(crew) - 1);

            //initialize job
            String job = "Placeholder";
            //Gunner- Damage Deckhand- Repair 
            this.console.println("Which Job?\n" + "G - Gunner\n" + "D - Deackhand\n" + "B- Boatswain\n");

            boolean valid;
            do {
                
                String inputJob = this.getInput("");
                
                switch (inputJob) {
                    case "G":
                        job = "Gunner";
                        valid = true;
                        break;

                    case "D":
                        job = "Deckhand";
                        valid = true;
                        break;

                    default:
                        valid = false;
                        this.console.println("Please enter a valid value");
                }

            } while (!valid);

            crew[inputInt].setJob(job);

        } catch (CrewControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void getCrewMenu(NPC[] crew) {
        String format = "%-3s %-20.20s %-10s %-10s %-10s %n";
        this.console.format(format, "#", "Name", "Job", "Attack", "Repair");
        
       this.console.println("=====================================================");
        
        format = " %-3d %-20.20s %-10s %-10d %-10d %n";
        for (int i = 0; i < crew.length; i++) {
            this.console.format(format, (i + 1), crew[i].getName(), crew[i].getJob(), crew[i].getCrewAttack(), crew[i].getCrewRepair());
        }
    }
    private int getInputCrewNumber(NPC[] crew) throws CrewControlException {
        if (crew.length == 0) {
            throw new CrewControlException("You have no crew");
        }
        int input = 0;
        
        do {
            String selection;
            try {
                 selection = getInput("Which # Crew Member?\n");
                 parseInt(selection);
            } catch (NumberFormatException ex) {
                Logger.getLogger(CrewView.class.getName()).log(Level.SEVERE, null, ex);
                this.console.println("Ye must enter a number");
            }
            
            //loop while there is no int, or if the int is not on the crew list

        } while (input < 1 || input > crew.length);

        return input;
    }

}

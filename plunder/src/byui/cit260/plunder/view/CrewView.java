/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.CrewControl;
import static byui.cit260.plunder.control.CrewControl.getCrew;
import static byui.cit260.plunder.control.CrewControl.getInputCrewNumber;
import byui.cit260.plunder.model.NPC;
import exceptions.CrewControlException;
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
                System.out.println("Invalid Menu Item");
                        

        }
        return false;
    }

    private void crewTalk(NPC[] crew) {
        System.out.println("Which # Crew Member?\n");

        int inputInt;
        try {
            inputInt = (getInputCrewNumber(crew) - 1);
            System.out.println("=================================================================\n"
                    + crew[inputInt].getName() + ":\n"
                    + crew[inputInt].getTalk()
                    + "\n=================================================================\n");
        } catch (CrewControlException ex) {
            Logger.getLogger(CrewView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No crew error");
        }

    }

    private void assignJob(NPC[] crew) {

        try {
            // get the crew member
            System.out.println("Which # Crew Member?\n");

            int inputInt = (CrewControl.getInputCrewNumber(crew) - 1);

            //initialize job
            String job = "Placeholder";
            //Gunner- Damage Deckhand- Repair 
            System.out.println("Which Job?\n" + "G - Gunner\n" + "D - Deackhand\n" + "B- Boatswain\n");

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
                        System.out.println("Please enter a valid value");
                }

            } while (!valid);

            crew[inputInt].setJob(job);

        } catch (CrewControlException ex) {
            Logger.getLogger(CrewView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("You have no crew");
        }
    }

    private void getCrewMenu(NPC[] crew) {
        String format = "%-3s %-20.20s %-10s %-10s %-10s %n";
        System.out.format(format, "#", "Name", "Job", "Attack", "Repair");
        
        System.out.println("=====================================================");
        
        format = " %-3d %-20.20s %-10s %-10d %-10d %n";
        for (int i = 0; i < crew.length; i++) {
            System.out.format(format, (i + 1), crew[i].getName(), crew[i].getJob(), crew[i].getCrewAttack(), crew[i].getCrewRepair());
        }
    }

}

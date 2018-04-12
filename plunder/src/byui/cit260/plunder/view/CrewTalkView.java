/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.CrewControl;
import byui.cit260.plunder.model.NPC;
import exceptions.CrewControlException;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class CrewTalkView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        this.getCrewMenu(CrewControl.getCrew());

        String crewMember = this.getInput("Which # Crew Member?\n");
        inputs[0] = crewMember;
        return inputs;
    }

    private void getCrewMenu(NPC[] crew) {
        String format = "%-3s %-20.20s %-10s %-10s %-10s %n";
        this.console.format(format, "#", "Name", "Job", "Attack", "Repair");

        this.console.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        format = " %-3d %-20.20s %-10s %-10d %-10d %n";
        for (int i = 0; i < crew.length; i++) {
            this.console.format(format, (i + 1), crew[i].getName(), crew[i].getJob(), crew[i].getCrewAttack(), crew[i].getCrewRepair());
        }
    }

    @Override
    public boolean doAction(String[] inputs) {
        NPC crewMember = null;
        try {
            int crewIndex = Integer.parseInt(inputs[0]) - 1;
            crewMember = CrewControl.getCrew()[crewIndex];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            ErrorView.display(this.getClass().getName(), "Invalid crew member");
            return false;
        }
     

        this.console.println(
                     
                  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + crewMember.getName() + ":\n"
                + crewMember.getTalk()
                + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        return true; 
    }

}

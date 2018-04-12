/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.CrewControl;
import byui.cit260.plunder.model.NPC;
import exceptions.CrewControlException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
class PrintCrewView extends View {

    @Override
    public String[] getInputs() {
        //declare new
        String[] inputs = new String[1];

        //instructions to save report
        this.console.println("Where do you want to save the file? \n Input Q to quit to main menu");

        //get input
        String input = this.getInput("Enter location: ");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        String filePath = inputs[0];

        if (filePath.equals("Q") || filePath.equals("q")) {
            this.console.println("Quitting to main menu");
            return true;
        }
        try {
            printCrew(filePath);
        } catch (CrewControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            return false;
        }

        this.console.println("Your file was saved to: " + filePath);

        return true;
    }

    private void printCrew(String filePath) throws CrewControlException {
        NPC[] crew = CrewControl.getCrew();
        if (crew == null || filePath.length() < 1 || crew.length < 1) {
            throw new CrewControlException("Error printing report, please try again.");
        }

        try (PrintWriter out = new PrintWriter(filePath)) {
            
            out.println("\n CREW REPORT\n");
            out.println("\n Crew Stats");
            
            String format = "%-3s %-20.20s %-10s %-10s %-10s %n";
            out.printf(format, "#", "Name", "Job", "Attack", "Repair");

            out.println("=====================================================");

            format = " %-3d %-20.20s %-10s %-10d %-10d %n";
            for (int i = 0; i < crew.length; i++) {
                out.printf(format, (i + 1), crew[i].getName(), crew[i].getJob(), crew[i].getCrewAttack(), crew[i].getCrewRepair());
            }

            
            out.println("\n\n Crew Conversations");
            for (NPC curNPC : crew) {
                out.println(curNPC.getName());
                out.println("===================");
                out.println(curNPC.getTalk() + "\n\n");
            }
            //flush any data from stream
            out.flush();
        } catch (IOException ex) {
            throw new CrewControlException(ex.getMessage());
        }
    }

}

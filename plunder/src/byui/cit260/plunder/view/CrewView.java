/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.NPC;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class CrewView {

    public void display(NPC[] npc) {
        //display the menu
        boolean endView = false;
        
      
        int numberOfCrew=0;
        for (int i = 0; i < npc.length; i++) {
            if (npc[i].getIsCrew()) {
                numberOfCrew++;
            }
            
        }
                
        NPC[] crew = new NPC[numberOfCrew];
        int t = 0;
        
        
        for (int i = 0; i < npc.length; i++) {
            if (npc[i].getIsCrew()) {
                crew[t] = npc[i];
                t++;
            }
            
        }
        
        do {
            System.out.println("\nYer Crew");
            String format = "%-20.20s %-3s %-10s %-10s %-10s %n";
            System.out.format(format, "#" ,"Name", "Job", "Attack", "Repair");
            System.out.println("=====================================================");
            format = " %-3d %-20.20s %-10s %-10d %-10d %n";
            for (int i = 0; i < crew.length  ; i++) {
                    System.out.format(format, (i + 1), crew[i].getName(), crew[i].getJob(), crew[i].getCrewAttack(), crew[i].getCrewRepair());
                
            }
            System.out.println("\nT - Talk to Crew" 
                             + "\nA - Assign Job" 
                             + "\nQ - Quit");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }

            endView = doAction(first, crew);
        } while (endView != true);
    }

    private String[] getInputs() {
        //get inputs from user
        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }

    private boolean doAction(String input, NPC[] npc) {
        //switch for the menu
        switch (input) {
            case "T":
                crewTalk(npc);
                break;
            case "A": 
                assignJob(npc);
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

        int inputInt = ( getInputCrewNumber(crew) - 1 );
        
        System.out.println("===============================\n" 
                + crew[inputInt].getName() + ":\n"
                + crew[inputInt].getTalk() 
                + "\n===============================\n");
        
    }

    private void assignJob(NPC[] crew) {
        
        // get the crew member
        System.out.println("Which # Crew Member?\n");

        int inputInt = ( getInputCrewNumber(crew) - 1 );
        
        //initialize job
        String job = "Placeholder";
        //Gunner- Damage Deckhand- Repair Boatswain - evasion
        System.out.println("Which Job?\n" + "G - Gunner\n" + "D - Deackhand\n" + "B- Boatswain\n");
        
        boolean valid;
        do{
            valid = true;
            String[] inputJob = getInputs();
            String firstInput = inputJob[0].toUpperCase();
            
            switch(firstInput)
                    {
                case "G" : 
                    job = "Gunner";
                break;
                
                case "D" : 
                    job = "Deckhand";
                break;
                
                case "B" :
                    job = "Boatswain"; 
                break;
                
                default:
                    valid = false;
                    System.out.println("Please enter a valid value");
            }

        } while(!valid);
                        
        crew[inputInt].setJob(job);
    }

    private int getInputCrewNumber(NPC[] crew) {
        Scanner scanNum = new Scanner(System.in);
        int input = 0;
        //loop while there is no int, or if the int is not on the crew list
        do {
            if (scanNum.hasNextInt()) {
                input = scanNum.nextInt();
            } else {
                System.out.println("Please enter the number of a crew member");
            }
        } while (input < 1 || input > crew.length);

        return input;
    }
}

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
    public void display(NPC[] npc){
        //display the menu
    boolean endView = false; 
        
        do{
             System.out.println("Yer Crew");
             String format = "%-20.20s %-10s %-10s %-10s %n";
             System.out.format(format, "Name", "Job", "Attack", "Repair" );
             System.out.println("========================================================/n");
             format = "%-20.20s %-10s %-10d %-10d %n";
              for (int i = 0; i < npc.length; i++) {
              if( npc[i].getIsCrew())
                  System.out.format(format, npc[i].getName(), npc[i].getJob(), npc[i].getCrewAttack(), npc[i].getCrewRepair());
              }
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }
            

            
        endView = doAction(first, npc);
    } while(endView != true);
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
     switch(input){
         case "T":
             crewTalk(npc);
             break;
            case "Q":
                //this is the only way to exit this loop
                return true;
                
            default:
                System.out.println("Invalid Menu Item");

        }
     return false;
    }

    private void crewTalk(NPC[] npc) {
        System.out.println("crewtalk called");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.CrewType;
import byui.cit260.plunder.model.NPC;
import exceptions.CrewControlException;
import java.util.Scanner;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class CrewControl {

    public static int getInputCrewNumber(NPC[] crew) throws CrewControlException {
        if (crew.length == 0) {
            throw new CrewControlException("No crew");
        }

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

    public static NPC[] getCrew() {
        // import the list of NPCs
        NPC[] npc = Plunder.getCurrentGame().getNPC();
        //get the crew using a loop
        int numberOfCrew = 0;
        for (NPC npc1 : npc) {
            if (npc1.getIsCrew()) {
                numberOfCrew++;
            }
        }

        NPC[] crew = new NPC[numberOfCrew];
        int t = 0;

        for (NPC npc1 : npc) {
            if (npc1.getIsCrew()) {
                crew[t] = npc1;
                t++;
            }
        }
        return crew;

    }

    static NPC[] createNPC() {
        NPC[] npc = new NPC[CrewType.values().length];

        NPC barry = new NPC();
        barry.setCrewAttack(5);
        barry.setCrewRepair(10);
        barry.setIsCrew(true);
        barry.setTalk("");
        barry.setName("Barry");
        barry.setJob("Deckhand");
        npc[CrewType.Barry.ordinal()] = barry;

        NPC larry = new NPC();
        larry.setCrewAttack(7);
        larry.setCrewRepair(7);
        larry.setIsCrew(true);
        larry.setTalk("");
        larry.setName("Larry");
        larry.setJob("Deckhand");
        npc[CrewType.Larry.ordinal()] = larry;

        NPC terry = new NPC();
        terry.setCrewAttack(3);
        terry.setCrewRepair(14);
        terry.setIsCrew(true);
        terry.setTalk("");
        terry.setName("Terry");
        terry.setJob("Deckhand");
        npc[CrewType.Terry.ordinal()] = terry;

        NPC steve = new NPC();
        steve.setCrewAttack(3);
        steve.setCrewRepair(14);
        steve.setIsCrew(true);
        steve.setTalk("");
        steve.setName("Steve");
        steve.setJob("Gunner");
        npc[CrewType.Steve.ordinal()] = steve;

        NPC wolfgang = new NPC();
        wolfgang.setCrewAttack(3);
        wolfgang.setCrewRepair(14);
        wolfgang.setIsCrew(true);
        wolfgang.setTalk("I hope the treseure is all gold and jewels!\n"
                + "I'm not a big fan of silver");
        wolfgang.setName("Wolfgang");
        wolfgang.setJob("Gunner");
        npc[CrewType.Wolfgang.ordinal()] = wolfgang;

        return npc;
    }
}

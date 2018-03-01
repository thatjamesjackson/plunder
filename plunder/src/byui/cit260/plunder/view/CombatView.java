/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.Ship;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class CombatView {
    
    public void display(Ship enemy){
        //display the menu
    boolean endView = false; 
        
        do{
            displayEnemyShip(enemy);
            displayStats();
             System.out.println("  A - Aimed Attack\n"
                    + "  C - Careful Attack\n"
                    + "  R - Reckless attack\n"
                    + "  F - Flee");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }
            

            
        endView = doAction(first);
    } while(endView != true);
    }


    private String[] getInputs() {
        //get inputs from user
        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }

    private boolean doAction(String input) {
        //switch for the menu
     switch (input) {
                case "R":
                    recklessAttack();
                    break;

                case "C":
                   carefulAttack();
                    break;

                case "A":
                   aimedAttack();
                    break;

                case "F":
                    //this is the only way to exit this loop
                    flee();
                    return true;
                default:
                        System.out.println("Invalid Menu Item");
                    
        }
     return false;
    }

    private void recklessAttack() {
        
    }

    private void flee() {
   
    }

    private void aimedAttack() {
   
    }

    private void carefulAttack() {
   
    }

    private void displayEnemyShip(Ship enemy) {
   
        if("Fishing Boat".equals(enemy.getName()) )
            System.out.println("     __/\\__\n" +
                               "  ~~~\\____/~~~~~~\n" +
                                "    ~  ~~~   ~.  ");
        if( "Sail Boat".equals(enemy.getName()) )
             System.out.println("    /|\\\n" +
                                "   /_|_\\\n" +
                                " ____|____\n" +
                                " \\_o_o_o_/\n");
        if("Clipper".equals(enemy.getName()) )
             System.out.println("       _~\n" +
                                "    _~ )_)_~\n" +
                                "    )_))_))_)\n" +
                                "    _!__!__!_\n" +
                                "    \\______t/\n" +
                                "  ~~~~~~~~~~~~~");
        if("Gunboat".equals(enemy.getName()) )
             System.out.println("   ^  +~+~~\n" +
                                "    ^   )`.).\n" +
                                "      )``)``) .~~\n" +
                                "      ).-'.-')|)\n" +
                                "    |-).-).-'_'-/\n" +
                                " ~~~\\ `o-o-o'  /~~~~~~~~\n" +
                                "  ~~~'---.____/~~~~~~~~~");
        if("Frigate".equals(enemy.getName()) )
             System.out.println("    __|__ |___| |\\\n" +
                                "    |o__| |___| | \\\n" +
                                "    |___| |___| |o \\\n" +
                                "   _|___| |___| |__o\\\n" +
                                "  /...\\_____|___|____\\_/\n" +
                                "  \\   o * o * * o o  /\n" +
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~");
                     
        if("Galleon".equals(enemy.getName()) )
             System.out.println("              |    |    |\n" +
                                "             )_)  )_)  )_)\n" +
                                "            )___))___))___)\\\n" +
                                "           )____)____)_____)\\\\\n" +
                                "         _____|____|____|____\\\\\\__\n" +
                                "---------\\                   /---------\n" +
                                "  ^^^^^ ^^^^^^^^^^^^^^^^^^^^^\n" +
                                "    ^^^^      ^^^^     ^^^    ^^\n" +
                                "         ^^^^      ^^^");
        if("Man of War".equals(enemy.getName()))
             System.out.println("                                   .        \n" +
                                "                                  /|~~                  \n" +
                                "                             ,   / |~~\n" +
                                "                            /|  /  |            \n" +
                                "                           / |~~   |     ,~~~~\n" +
                                "                          /  |~~   |    /|~~~~\n" +
                                "                         /   |     |   / |\n" +
                                "                        /    |     |  /  |\n" +
                                "                       /     |     | /   |\n" +
                                "                      /      |     |/    |\n" +
                                "          =====______/       |     |=====|  __\n" +
                                "             \\   __ \\========|=====|    / \\|__)\n" +
                                "              \\'V` _\\o_o_o_o_o_o_o_o_o_o_o_o__)   Midnight\n" +
                                "               \\ -------  --  ---- - -  --- /\n" +
                                "                \\  ----------- -  --- ----  |}\n" +
                                "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        if("Sea Monster".equals(enemy.getName()))
             System.out.println("                       _..--+~/c-~--.\n" +
                                "                   _-=~      (  .   '\n" +
                                "                _-~     _.--=.\\ \\''''\n" +
                                "              _~      _-       \\ \\_\\\n" +
                                "             =      _=          '--'\n" +
                                "            '      =                             .\n" +
                                "           :      :       ____                   '=_. ___\n" +
                                "      ___  |      ;                            ____ '~--.~.\n" +
                                "           ;      ;                               _____  } |\n" +
                                "        ___=       \\ ___ __     __..-...__           ___/__/__\n" +
                                "           :        =_     _.-~~          ~~--.__\n" +
                                "      _____ \\         ~-+-~                   ___~=_______\n" +
                                "           ~@#~~ == ...______ __ ___ _--~~--_");
    }

    private void displayStats() {
    
    }
}

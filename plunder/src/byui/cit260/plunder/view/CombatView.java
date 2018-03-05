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

    public int display(Ship player, Ship enemy) {
        //display the menu
        boolean endView = false;

        do {
            displayEnemyShip(enemy);
            displayStats(player, enemy);
            System.out.println("\n  A - Aimed Attack\n"
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

            //if either ship is sunk combat is over
            if (player.getShipHealth() <= 0 || enemy.getShipHealth() <= 0) {
                endView = true;
            }

        } while (endView != true);
        
        if (enemy.getShipHealth() <= 0)
            return 0;
        else if (player.getShipHealth() <= 0 )
            return 1;
        else return 2;
        
    }

    public CombatView() {
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
                //take an attack and run away
                flee();
                return true;
            default:
                System.out.println("Invalid Menu Item");

        }
        return false;
    }

    private void recklessAttack() {
        System.out.println("reckless attack called");
    }

    private void flee() {
        System.out.println("flee called");
    }

    private void aimedAttack() {
        System.out.println("aimed attack called");
    }

    private void carefulAttack() {
        System.out.println("careful attack called");
    }

    private void displayEnemyShip(Ship enemy) {

        if ("Fishing Boat".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "     __/\\__\n"
                    + "  ~~~\\____/~~~~~~\n"
                    + "    ~  ~~~   ~.  ");
        }
        if ("Sail Boat".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "    /|\\\n"
                    + "   /_|_\\\n"
                    + " ____|____\n"
                    + " \\_o_o_o_/\n");
        }
        if ("Clipper".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "       _~\n"
                    + "    _~ )_)_~\n"
                    + "    )_))_))_)\n"
                    + "    _!__!__!_\n"
                    + "    \\______t/\n"
                    + "  ~~~~~~~~~~~~~");
        }
        if ("Gunboat".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "   ^  +~+~~\n"
                    + "    ^   )`.).\n"
                    + "      )``)``) .~~\n"
                    + "      ).-'.-')|)\n"
                    + "    |-).-).-'_'-/\n"
                    + " ~~~\\ `o-o-o'  /~~~~~~~~\n"
                    + "  ~~~'---.____/~~~~~~~~~");
        }
        if ("Frigate".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "    __|__ |___| |\\\n"
                    + "    |o__| |___| | \\\n"
                    + "    |___| |___| |o \\\n"
                    + "   _|___| |___| |__o\\\n"
                    + "  /...\\_____|___|____\\_/\n"
                    + "  \\   o * o * * o o  /\n"
                    + "~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        if ("Galleon".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "              |    |    |\n"
                    + "             )_)  )_)  )_)\n"
                    + "            )___))___))___)\\\n"
                    + "           )____)____)_____)\\\\\n"
                    + "         _____|____|____|____\\\\\\__\n"
                    + "---------\\                   /---------\n"
                    + "  ^^^^^ ^^^^^^^^^^^^^^^^^^^^^\n"
                    + "    ^^^^      ^^^^     ^^^    ^^\n"
                    + "         ^^^^      ^^^");
        }
        if ("Man of War".equals(enemy.getName())) {
            System.out.println(enemy.getName()+ "\n"
                    + "                                   .        \n"
                    + "                                  /|~~                  \n"
                    + "                             ,   / |~~\n"
                    + "                            /|  /  |            \n"
                    + "                           / |~~   |     ,~~~~\n"
                    + "                          /  |~~   |    /|~~~~\n"
                    + "                         /   |     |   / |\n"
                    + "                        /    |     |  /  |\n"
                    + "                       /     |     | /   |\n"
                    + "                      /      |     |/    |\n"
                    + "          =====______/       |     |=====|  __\n"
                    + "             \\   __ \\========|=====|    / \\|__)\n"
                    + "              \\'V` _\\o_o_o_o_o_o_o_o_o_o_o_o__)           \n"
                    + "               \\ -------  --  ---- - -  --- /\n"
                    + "                \\  ----------- -  --- ----  |}\n"
                    + "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        if ("Sea Monster".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
                    + "                       _..--+~/c-~--.\n"
                    + "                   _-=~      (  .   '\n"
                    + "                _-~     _.--=.\\ \\''''\n"
                    + "              _~      _-       \\ \\_\\\n"
                    + "             =      _=          '--'\n"
                    + "            '      =                             .\n"
                    + "           :      :       ____                   '=_. ___\n"
                    + "      ___  |      ;                            ____ '~--.~.\n"
                    + "           ;      ;                               _____  } |\n"
                    + "        ___=       \\ ___ __     __..-...__           ___/__/__\n"
                    + "           :        =_     _.-~~          ~~--.__\n"
                    + "      _____ \\         ~-+-~                   ___~=_______\n"
                    + "           ~##~~ == ...______ __ ___ _--~~--_");
        }
    }

    private void displayStats(Ship player, Ship enemy) {

     
        String format = "%-20.20s %-20.20s";
        System.out.format(format, player.getName(), enemy.getName());
        //for whatever reason format adds a space on the first line, so we add a space on subsiqent lines to compensate
        System.out.format(format, "\nHealth: " + player.getShipHealth(), " Health: " + enemy.getShipHealth() );
        System.out.format(format, "\nAttack: " + player.getShipAttack(), " Attack: " + enemy.getShipAttack());
        System.out.format(format, "\nArmor: " + player.getArmor(), " Armor: " + enemy.getArmor());
        
    }
}

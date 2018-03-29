/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import java.util.Random;
import byui.cit260.plunder.control.CombatControl;
import byui.cit260.plunder.model.Ship;
import exceptions.CombatControlException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author James
 */
public class CombatView extends View{

    public CombatView() {
    }

    @Override
    public String[] getInputs() {
        //get inputs from user
        String[] inputs = new String[1];
        inputs[0] = this.getInput("\n  A - Aimed Attack\n"
                + "  C - Careful Attack\n"
                + "  R - Reckless attack\n"
                + "  F - Flee");
        return inputs;
       
    }
    
    @Override
    public boolean doAction(String[] inputs) {
                    //get enemy and player. need to implement later
            Ship enemy = new Ship();
            Ship player = new Ship();
            //display for player
            displayEnemyShip(enemy);
            displayStats(player, enemy);
            
            //random number generator
            Random random = new Random();
            
            //players stats
            double pAttack = player.getShipAttack() + (double) random.nextInt(100) / 10;
            double pArmor = player.getArmor();
            int pAccuracy = 50;
            int pEvasion = 50;
            
            //enemy stats
            double eAttack = enemy.getShipAttack() + (double) random.nextInt(100) / 10;
            double eArmor = enemy.getArmor();
            int eAccuracy = 50;
            int eEvasion = 50;
            
            //initilize damage
            
            double damage = 0;
            
            boolean flee = false;
        try {

            //switch for the menu
            switch (inputs[0]) {
                case "R":
                    pAttack = pAttack * 2;
                    pEvasion = pEvasion - 20;
                    break;
                    
                case "C":
                    pEvasion = pEvasion + 20;
                    break;
                    
                case "A":
                    pAccuracy = pAccuracy + 20;
                    break;
                    
                case "F":
                    //take an attack and run away
                    
                    flee = true;
                    break;
                default:
                    System.out.println("Invalid Menu Item");
            }
            
            
            //player's attack
            //random numbers must be no larger than 25 and nextint has an exclusive upper bound, so i use 26
            if (CombatControl.doesHit(pAccuracy, eEvasion, random.nextInt(26), random.nextInt(26)) == 1 && !flee) {
                damage = CombatControl.attackDamage(pAttack, eArmor);
                enemy.setShipHealth(enemy.getShipHealth() - damage);
                //round output
                System.out.println("\nYeh hit " + enemy.getName() + " for " + Math.round(damage * 100.0) + " damage!\n");
            } else {
                System.out.println("\nYeh Missed!\n");
            }
            //enemy attack
            
            if (CombatControl.doesHit(eAccuracy, pEvasion, random.nextInt(26), random.nextInt(26)) == 1) {
                damage = CombatControl.attackDamage(eAttack, pArmor);
                player.setShipHealth(player.getShipHealth() - damage);
                //round output
                System.out.println(enemy.getName() + " hit for " + Math.round(damage * 100.0) + " damage!\n");
            } else {
                System.out.println(enemy.getName() + " Missed!\n");
            }
            
            //repair out is only used to tell the player how much damage is repaired
            double repairOut;
            //repair if you are still floating
            if (player.getShipHealth() > 0) {
                //repair
                player.setShipHealth(player.getShipHealth() + player.getShipRepair());
                //your hp cannot be above max
                if (player.getShipMaxHealth() < player.getShipHealth()) {
                    
                    repairOut = player.getShipHealth() - player.getShipMaxHealth();
                    player.setShipHealth(player.getShipMaxHealth());
                } else {
                    repairOut = player.getShipRepair();
                }
                System.out.println("Yer crew repaired " + repairOut + " damage\n");
            }
            
            
        } catch (CombatControlException ex) {
            Logger.getLogger(CombatView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Combat Error");
        }
        if (enemy.getShipHealth() <= 0) {
                //enemy sank
                System.out.println("Yer opponent sank!\n");
                return true;
            } else if (player.getShipHealth() <= 0 && flee) {
                System.out.println("Yeh sank while turning tail!\n");
                return true;
            } else if (player.getShipHealth() <= 0) {
                //you sank
                System.out.println("Yeh sank!\n");
                return true;
            }else
                return false;
    }

    private void displayEnemyShip(Ship enemy) {

        if ("Fishing Boat".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
                    + "     __/\\__\n"
                    + "  ~~~\\____/~~~~~~\n"
                    + "    ~  ~~~   ~.  ");
        }
        if ("Sail Boat".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
                    + "    /|\\\n"
                    + "   /_|_\\\n"
                    + " ____|____\n"
                    + " \\_o_o_o_/\n");
        }
        if ("Clipper".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
                    + "       _~\n"
                    + "    _~ )_)_~\n"
                    + "    )_))_))_)\n"
                    + "    _!__!__!_\n"
                    + "    \\______t/\n"
                    + "  ~~~~~~~~~~~~~");
        }
        if ("Gunboat".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
                    + "   ^  +~+~~\n"
                    + "    ^   )`.).\n"
                    + "      )``)``) .~~\n"
                    + "      ).-'.-')|)\n"
                    + "    |-).-).-'_'-/\n"
                    + " ~~~\\ `o-o-o'  /~~~~~~~~\n"
                    + "  ~~~'---.____/~~~~~~~~~");
        }
        if ("Frigate".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
                    + "    __|__ |___| |\\\n"
                    + "    |o__| |___| | \\\n"
                    + "    |___| |___| |o \\\n"
                    + "   _|___| |___| |__o\\\n"
                    + "  /...\\_____|___|____\\_/\n"
                    + "  \\   o * o * * o o  /\n"
                    + "~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        if ("Galleon".equals(enemy.getName())) {
            System.out.println(enemy.getName() + "\n"
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
            System.out.println(enemy.getName() + "\n"
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
        //round output 
        System.out.format(format, "\nHealth: " + Math.round(player.getShipHealth() * 100.0) / 100.0, " Health: " + Math.round(enemy.getShipHealth() * 100.0) / 100.0);
        System.out.format(format, "\nAttack: " + player.getShipAttack(), " Attack: " + enemy.getShipAttack());
        System.out.format(format, "\nArmor: " + player.getArmor(), " Armor: " + enemy.getArmor());

    }

    
}

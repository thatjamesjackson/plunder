/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import java.util.Random;
import byui.cit260.plunder.control.CombatControl;
import byui.cit260.plunder.control.CrewControl;
import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.CombatScene;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.InventoryItemType;
import byui.cit260.plunder.model.NPC;
import byui.cit260.plunder.model.Ship;
import exceptions.CombatControlException;
import java.util.ArrayList;
import plunder.Plunder;

/**
 *
 * @author James
 */
public class CombatView extends View {

    public CombatView() {
    }

    @Override
    public String[] getInputs() {
        //get inputs from user
        String[] inputs = new String[1];
        CombatScene scene = (CombatScene) Plunder.getCurrentGame().getMap().getLocation()[(int) Plunder.getPlayer().getActor().getCoordinates().getY()][(int) Plunder.getPlayer().getActor().getCoordinates().getX()].getScene();
        Ship enemy = scene.getOpponent();
        Ship player = Plunder.getPlayer().getShip();
        displayEnemyShip(enemy);
        displayStats(player, enemy);
        inputs[0] = this.getInput("\n  A - Aimed Attack\n"
                + "  C - Careful Attack\n"
                + "  R - Reckless attack\n"
                + "  F - Flee");
        return inputs;

    }

    @Override
    public boolean doAction(String[] inputs) {
        //get enemy and player. need to implement later
        CombatScene scene = (CombatScene) Plunder.getCurrentGame().getMap().getLocation()[(int) Plunder.getPlayer().getActor().getCoordinates().getY()][(int) Plunder.getPlayer().getActor().getCoordinates().getX()].getScene();
        Ship enemy = scene.getOpponent();
        Ship player = Plunder.getPlayer().getShip();
        //display for player

        //random number generator
        Random random = new Random();

        //players stats
        double pAttack = player.getShipAttack() + CrewControl.getCrewAttack() + (double) random.nextInt(100) / 10;
        double pArmor = player.getArmor();
        int pAccuracy = 50;
        int pEvasion = 50;
        double repair = player.getShipRepair() + CrewControl.getCrewRepair();

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
                    ErrorView.display(this.getClass().getName(), "Invalid option");
            }

            //player's attack
            //random numbers must be no larger than 25 and nextint has an exclusive upper bound, so i use 26
            if (CombatControl.doesHit(pAccuracy, eEvasion, random.nextInt(26), random.nextInt(26)) == 1 && !flee) {
                damage = CombatControl.attackDamage(pAttack, eArmor);
                enemy.setShipHealth(enemy.getShipHealth() - damage);
                //round output
                this.console.println("\nYeh hit " + enemy.getName() + " for " + Math.round(damage * 100.0) / 100.0 + " damage!\n");
            } else {
                this.console.println("\nYeh Missed!\n");
            }
            //enemy attack

            if (CombatControl.doesHit(eAccuracy, pEvasion, random.nextInt(26), random.nextInt(26)) == 1) {
                damage = CombatControl.attackDamage(eAttack, pArmor);
                player.setShipHealth(player.getShipHealth() - damage);
                //round output
                this.console.println(enemy.getName() + " hit for " + Math.round(damage * 100.0) / 100.0 + " damage!\n");
            } else {
                this.console.println(enemy.getName() + " Missed!\n");
            }

            //repair out is only used to tell the player how much damage is repaired
            double repairOut;
            //repair if you are still floating
            if (player.getShipHealth() > 0) {
                //repair
                player.setShipHealth(player.getShipHealth() + repair);
                //your hp cannot be above max
                if (player.getShipMaxHealth() < player.getShipHealth()) {

                    repairOut = player.getShipHealth() - player.getShipMaxHealth();
                    player.setShipHealth(player.getShipMaxHealth());
                } else {
                    repairOut = repair;
                }
                this.console.println("Yer crew repaired " + Math.round(repairOut * 100) / 100 + " damage\n");
            }

        } catch (CombatControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        if (enemy.getShipHealth() <= 0) {
            //enemy sank
            this.console.println("Yer opponent sank!\n");
            //respawn opponent for next game
            enemy.setShipHealth(enemy.getShipMaxHealth());
            
            Double gain = enemy.getCarryWeight() + (double) random.nextInt((int) (enemy.getCarryWeight() / 5));
            Plunder.getCurrentGame().setMoney(Plunder.getCurrentGame().getMoney() + gain);
            this.console.println("Ye looted " + gain + " gold off yonder ship");
            ArrayList<InventoryItem> inv = Plunder.getCurrentGame().getPlayer().getShip().getInventory();
            for (NPC curCrew : CrewControl.getCrew()) {
                int loot = random.nextInt(10);
                int numLoot = random.nextInt((int) (enemy.getCarryWeight() / 50) + 1);
                if (loot == InventoryItemType.coconut.ordinal()) {
                    InventoryControl.addItem(numLoot, inv, "O");
                    this.console.println(curCrew.getName() + " looted " + numLoot + " coconuts");
                } else if (loot == InventoryItemType.cotton.ordinal()) {
                    InventoryControl.addItem(numLoot, inv, "C");
                                        this.console.println(curCrew.getName() + " looted " + numLoot + " crates of cotton");
                } else if (loot == InventoryItemType.fish.ordinal()) {
                    InventoryControl.addItem(numLoot, inv, "F");
                    this.console.println(curCrew.getName() + " looted " + numLoot + " barrels of fish");
                } else if (loot == InventoryItemType.jewels.ordinal()) {
                    InventoryControl.addItem(numLoot, inv, "J");
                    this.console.println(curCrew.getName() + " looted " + numLoot + " jewels");
                } else if (loot == InventoryItemType.spices.ordinal()) {
                    InventoryControl.addItem(numLoot, inv, "S");
                    this.console.println(curCrew.getName() + " looted " + numLoot + " bags of spices");
                } else {
                    this.console.println(curCrew.getName() + " could not find anything worthwile to loot");
                }
            }
            return true;
        } else if (player.getShipHealth() <= 0 && flee) {
            this.console.println("Yeh sank while turning tail!\n");
            enemy.setShipHealth(enemy.getShipMaxHealth());
            return true;
        } else if (player.getShipHealth() <= 0) {
            //you sank
            this.console.println("Yeh sank!\n");
            enemy.setShipHealth(enemy.getShipMaxHealth());
            return true;
        } else if (flee) {
            this.console.println("Yeh ran you coward!\n");
            enemy.setShipHealth(enemy.getShipMaxHealth());
            return true;
        } else {
            return false;
        }
    }

    private void displayEnemyShip(Ship enemy) {

        if ("Fishing Boat".equals(enemy.getName())) {
            this.console.println(enemy.getName() + "\n"
                    + "     __/\\__\n"
                    + "  ~~~\\____/~~~~~~\n"
                    + "    ~  ~~~   ~.  ");
        }
        if ("Sail Boat".equals(enemy.getName())) {
            this.console.println(enemy.getName() + "\n"
                    + "    /|\\\n"
                    + "   /_|_\\\n"
                    + " ____|____\n"
                    + " \\_o_o_o_/\n");
        }
        if ("Clipper".equals(enemy.getName())) {
            this.console.println(enemy.getName() + "\n"
                    + "       _~\n"
                    + "    _~ )_)_~\n"
                    + "    )_))_))_)\n"
                    + "    _!__!__!_\n"
                    + "    \\______t/\n"
                    + "  ~~~~~~~~~~~~~");
        }
        if ("Gunboat".equals(enemy.getName())) {
            this.console.println(enemy.getName() + "\n"
                    + "   ^  +~+~~\n"
                    + "    ^   )`.).\n"
                    + "      )``)``) .~~\n"
                    + "      ).-'.-')|)\n"
                    + "    |-).-).-'_'-/\n"
                    + " ~~~\\ `o-o-o'  /~~~~~~~~\n"
                    + "  ~~~'---.____/~~~~~~~~~");
        }
        if ("Frigate".equals(enemy.getName())) {
            this.console.println(enemy.getName() + "\n"
                    + "    __|__ |___| |\\\n"
                    + "    |o__| |___| | \\\n"
                    + "    |___| |___| |o \\\n"
                    + "   _|___| |___| |__o\\\n"
                    + "  /...\\_____|___|____\\_/\n"
                    + "  \\   o * o * * o o  /\n"
                    + "~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        if ("Galleon".equals(enemy.getName())) {
            this.console.println(enemy.getName() + "\n"
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
            this.console.println(enemy.getName() + "\n"
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
            this.console.println(enemy.getName() + "\n"
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
        this.console.format(format, player.getName(), enemy.getName());
        //for whatever reason format adds a space on the first line, so we add a space on subsiqent lines to compensate
        //round output 
        this.console.format(format, "\nHealth: " + Math.round(player.getShipHealth() * 100.0) / 100.0, " Health: " + Math.round(enemy.getShipHealth() * 100.0) / 100.0);
        this.console.format(format, "\nAttack: " + player.getShipAttack(), " Attack: " + enemy.getShipAttack());
        this.console.format(format, "\nArmor: " + player.getArmor(), " Armor: " + enemy.getArmor());

    }

}

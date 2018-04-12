/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Ship;
import byui.cit260.plunder.model.ShipType;
import exceptions.CombatControlException;

/**
 *
 * @author abigailking
 */
public class CombatControl {

    public static Ship enemyShipConstructor(int danger) {
        Ship enemy = new Ship();

        //create enemies
        if (danger == ShipType.fishingBoat.ordinal()) {
            enemy.setName("Fishing Boat");
            enemy.setShipAttack(10);
            enemy.setCarryWeight(100);
            enemy.setArmor(5);
            enemy.setShipRepair(1);
            enemy.setShipHealth(50);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.sailBoat.ordinal()) {
            enemy.setName("Sail Boat");
            enemy.setShipAttack(20);
            enemy.setCarryWeight(200);
            enemy.setArmor(10);
            enemy.setShipRepair(5);
            enemy.setShipHealth(100);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.clipper.ordinal()) {
            enemy.setName("Clipper");
            enemy.setShipAttack(45);
            enemy.setCarryWeight(300);
            enemy.setArmor(20);
            enemy.setShipRepair(15);
            enemy.setShipHealth(200);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.gunBoat.ordinal()) {
            enemy.setName("Gunboat");
            enemy.setShipAttack(75);
            enemy.setCarryWeight(500);
            enemy.setArmor(35);
            enemy.setShipRepair(20);
            enemy.setShipHealth(300);
           enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.frigate.ordinal()) {
            enemy.setName("Frigate");
            enemy.setShipAttack(100);
            enemy.setCarryWeight(700);
            enemy.setArmor(45);
            enemy.setShipRepair(30);
            enemy.setShipHealth(400);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.galleon.ordinal()) {
            enemy.setName("Galleon");
            enemy.setShipAttack(120);
            enemy.setCarryWeight(1000);
            enemy.setArmor(50);
            enemy.setShipRepair(50);
            enemy.setShipHealth(600);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.manOfWar.ordinal()) {
            enemy.setName("Man of War");
            enemy.setShipAttack(160);
            enemy.setCarryWeight(1500);
            enemy.setArmor(60);
            enemy.setShipRepair(70);
            enemy.setShipHealth(800);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }
        if (danger == ShipType.seaMonster.ordinal()) {
            enemy.setName("Sea Monster");
            enemy.setShipAttack(200);
            enemy.setCarryWeight(500);
            enemy.setArmor(20);
            enemy.setShipRepair(0);
            enemy.setShipHealth(2000);
            enemy.setShipMaxHealth(enemy.getShipHealth());
        }

        return enemy;
    }

    public static double recklessAttackDamage(double attack, double armor) throws CombatControlException {
// attack is less than or equal to 0
        if (attack <= 0) {
            throw new CombatControlException("The attack can not be zero.");
        }
//defender has too much armor
        if (armor >= 100) {
            throw new CombatControlException("The defender has too much armor.");
        }
//defender has negative armor
        if (armor < 0) {
            throw new CombatControlException("The defender has a negavtive value for armor.");
        }
        double damage = attack * 2 * (100 - armor) / 100;
        return damage;

    }

    public static double attackDamage(double attack, double armor) throws CombatControlException {
// attack is less than or equal to 0
        if (attack <= 0) {
            throw new CombatControlException("The attack is less than or equal to zero.");
        }
//defender has too much armor
        if (armor >= 100) {
            throw new CombatControlException("The defender has too much armor.");
        }
//defender has negative armor
        if (armor < 0) {
            throw new CombatControlException("The defender has a negative value for armor.");
        }
        double damage = attack * (100 - armor) / 100;
        return damage;

    }

    public static int doesHit(int accuracy, int evasion, int chance1, int chance2) throws CombatControlException {

        // int chance = randomGen.nextInt(26);
// limit negative numbers
        if (accuracy < 0 || evasion < 0) {
            throw new CombatControlException("The value can not be a negative .");
        }

// limit chance between 0 and 25
        if (chance1 < 0 || chance1 > 25 && chance2 < 0 || chance2 > 25) {
            throw new CombatControlException("Must limit chance between 0 and 25.");
        }

// evaluate for hit even if happen to be equal
        if (accuracy + chance1 >= evasion + chance2) {
            return 1;
        }

        return 0;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

/**
 *
 * @author abigailking
 */
public class CombatControl {

    public double recklessAttackDamage(double attack, double armor) {
// attack is less than or equal to 0
        if (attack <= 0) {
            return - 1;
        }
//defender has too much armor
        if (armor >= 100) {
            return - 2;
        }
//defender has negative armor
        if (armor < 0) {
            return -3;
        }
        double damage = attack * 2 * (100 - armor) / 100;
        return damage;

    }

    public double normalAttackDamage(double attack, double armor) {
// attack is less than or equal to 0
        if (attack <= 0) {
            return - 1;
        }
//defender has too much armor
        if (armor >= 100) {
            return - 2;
        }
//defender has negative armor
        if (armor < 0) {
            return -3;
        }
        double damage = attack * (100 - armor) / 100;
        return damage;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import java.util.Random;

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
    
    public int doesHit(int accuracy, int evasion, int chance1, int chance2) {
        Random randomGen = new Random();
        
        // int chance = randomGen.nextInt(26);
        
// limit negative numbers
        if (accuracy < 0 || evasion < 0) {
            return -1;
        }
        
// limit chance between 0 and 25
        if (chance1 < 0 || chance1 > 25 && chance2 < 0 || chance2 > 25) {
            return -2;
        }
        
// evaluate for hit even if happen to be equal
        if (accuracy + chance1 >= evasion + chance2){
            return 1;
        }
        
        return 0;
    } 
    
}

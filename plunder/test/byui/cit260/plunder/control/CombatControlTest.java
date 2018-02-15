/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James
 */
public class CombatControlTest {
    
    public CombatControlTest() {
    }

    /**
     * Test of recklessAttackDamage method, of class CombatControl.
     */
    @Test
    public void testRecklessAttackDamage() {
        System.out.println("recklessAttackDamage");
        System.out.println("\ttest case 1");
        double attack = 10.0;
        double armor = 10.0;
        CombatControl instance = new CombatControl();
        double expResult = 18.0;
        double result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 2");
        attack = 30.0;
        armor = 20.0;
        instance = new CombatControl();
        expResult = 48.0;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 3");
        attack = 20.0;
        armor = 30.0;
        instance = new CombatControl();
        expResult = 28.0;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 4");
        attack = 10.0;
        armor = 110.0;
        instance = new CombatControl();
        expResult = -2;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 5");
        attack = 0.0;
        armor = 2.0;
        instance = new CombatControl();
        expResult = -1.0;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
    
        System.out.println("\ttest case 6");
        attack = -10.0;
        armor = 20.0;
        instance = new CombatControl();
        expResult = -1.0;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
    
        System.out.println("\ttest case 7");
        attack = 10.0;
        armor = -10.0;
        instance = new CombatControl();
        expResult = -3.0;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
    
        System.out.println("\ttest case 8");
        attack = 10.0;
        armor = 0.0;
        instance = new CombatControl();
        expResult = 20.0;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 9");
        attack = 10.0;
        armor = 99.0;
        instance = new CombatControl();
        expResult = 0.2;
        result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of normalAttackDamage method, of class CombatControl.
     */
    @Test
    public void testNormalAttackDamage() {
        System.out.println("normalAttackDamage");
        System.out.println("\ttest case 1");
        double attack = 10.0;
        double armor = 10.0;
        CombatControl instance = new CombatControl();
        double expResult = 9.0;
        double result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 2");
        attack = 30.0;
        armor = 20.0;
        instance = new CombatControl();
        expResult = 24.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 3");
        attack = 20.0;
        armor = 30.0;
        instance = new CombatControl();
        expResult = 14.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 4");
        attack = 10.0;
        armor = 110.0;
        instance = new CombatControl();
        expResult = -2.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 5");
        attack = 0.0;
        armor = 2.0;
        instance = new CombatControl();
        expResult = -1.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 6");
        attack = -10.0;
        armor = 20.0;
        instance = new CombatControl();
        expResult = -1.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 7");
        attack = 10.0;
        armor = -10.0;
        instance = new CombatControl();
        expResult = -3.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 8");
        attack = 10.0;
        armor = 0.0;
        instance = new CombatControl();
        expResult = 10.0;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 9");
        attack = 10.0;
        armor = 99.0;
        instance = new CombatControl();
        expResult = 0.1;
        result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
    }
    
}

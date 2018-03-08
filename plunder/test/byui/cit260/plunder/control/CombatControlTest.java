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
        double result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 2");
        attack = 30.0;
        armor = 20.0;
        instance = new CombatControl();
        expResult = 24.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 3");
        attack = 20.0;
        armor = 30.0;
        instance = new CombatControl();
        expResult = 14.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 4");
        attack = 10.0;
        armor = 110.0;
        instance = new CombatControl();
        expResult = -2.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 5");
        attack = 0.0;
        armor = 2.0;
        instance = new CombatControl();
        expResult = -1.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 6");
        attack = -10.0;
        armor = 20.0;
        instance = new CombatControl();
        expResult = -1.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 7");
        attack = 10.0;
        armor = -10.0;
        instance = new CombatControl();
        expResult = -3.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 8");
        attack = 10.0;
        armor = 0.0;
        instance = new CombatControl();
        expResult = 10.0;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 9");
        attack = 10.0;
        armor = 99.0;
        instance = new CombatControl();
        expResult = 0.1;
        result = instance.attackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of doesHit method, of class CombatControl.
     */
    @Test
    public void testDoesHit() {
        System.out.println("doesHit");
        
        //--- Test Case 1 ---
        System.out.println("\tTest Case 1");
        
        int accuracy = 30;
        int evasion = 22;
        int chance1 = 9;
        int chance2 = 5;
        CombatControl instance = new CombatControl();
        int expResult = 1;
        int result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
        
        //--- Test Case 2 ---
        System.out.println("\tTest Case 2");
        accuracy = -10;
        evasion = 25;
        chance1 = 0;
        chance2 = 7;
        
        instance = new CombatControl();
        expResult = -1;
        result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
        
        //--- Test Case 3 ---
        System.out.println("\tTest Case 3");
        accuracy = 14;
        evasion = -30;
        chance1 = 17;
        chance2 = 12;
        
        instance = new CombatControl();
        expResult = -1;
        result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
        
        //--- Test Case 4 ---
        System.out.println("\tTest Case 4");
        accuracy = -10;
        evasion = -20;
        chance1 = 15;
        chance2 = 15;
        
        instance = new CombatControl();
        expResult = -1;
        result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
        
        //--- Test Case 5 ---
        System.out.println("\tTest Case 5");
        accuracy = 0;
        evasion = 30;
        chance1 = 0;
        chance2 = 25;
        
        instance = new CombatControl();
        expResult = 0;
        result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
        
        //--- Test Case 6 ---
        System.out.println("\tTest Case 6");
        accuracy = 30;
        evasion = 0;
        chance1 = 25;
        chance2 = 0;
        
        instance = new CombatControl();
        expResult = 1;
        result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
        
        //--- Test Case 7 ---
        System.out.println("\tTest Case 7");
        accuracy = 20;
        evasion = 10;
        chance1 = 10;
        chance2 = 20;
        
        instance = new CombatControl();
        expResult = 1;
        result = instance.doesHit(accuracy, evasion, chance1, chance2);
        assertEquals(expResult, result);
    }
    
}

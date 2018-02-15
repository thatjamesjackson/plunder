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
 * @author abigailking
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
        double attack = 0.0;
        double armor = 0.0;
        CombatControl instance = new CombatControl();
        double expResult = 0.0;
        double result = instance.recklessAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normalAttackDamage method, of class CombatControl.
     */
    @Test
    public void testNormalAttackDamage() {
        System.out.println("normalAttackDamage");
        double attack = 0.0;
        double armor = 0.0;
        CombatControl instance = new CombatControl();
        double expResult = 0.0;
        double result = instance.normalAttackDamage(attack, armor);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

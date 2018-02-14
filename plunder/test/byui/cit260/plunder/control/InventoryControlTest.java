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
public class InventoryControlTest {
    
    public InventoryControlTest() {
    }

    /**
     * Test of calculateWeight method, of class InventoryControl.
     */
    @Test
    public void testCalculateWeight() {
        System.out.println("calculateWeight");
        System.out.println("\ttest case 1");
        double[] itemWeight = {12,115};
        double[] itemQuantity = {1,3};
        InventoryControl instance = new InventoryControl();
        double expResult = 357;
        double result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 2");
        itemWeight[0] = 1;
        itemWeight[1] = 1;
        itemQuantity[0] = 1;
        itemQuantity[1] = 1;
        instance = new InventoryControl();
        expResult = 2;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\ttest case 3");
        itemWeight[0] = 0;
        itemWeight[1] = 1000;
        itemQuantity[0] = 10;
        itemQuantity[1] = 1;
        instance = new InventoryControl();
        expResult = 1000;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 4");
        itemWeight[0] = 500;
        itemWeight[1] = 1000;
        itemQuantity[0] = 1;
        itemQuantity[1] = 0;
        instance = new InventoryControl();
        expResult = 500;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 5");
        itemWeight[0] = -1;
        itemWeight[1] = 1;
        itemQuantity[0] = 10;
        itemQuantity[1] = 10;
        instance = new InventoryControl();
        expResult = -1;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 6");
        itemWeight[0] = 10;
        itemWeight[1] = 100;
        itemQuantity[0] = -1;
        itemQuantity[1] = 5;
        instance = new InventoryControl();
        expResult = -2;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 7");
        itemWeight[0] = 100;
        itemWeight[1] = -1;
        itemQuantity[0] = 5;
        itemQuantity[1] = 10;
        instance = new InventoryControl();
        expResult = -1;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);

        System.out.println("\ttest case 8");
        itemWeight[0] = 1;
        itemWeight[1] = 10;
        itemQuantity[0] = 10;
        itemQuantity[1] = -1;
        instance = new InventoryControl();
        expResult = -2;
        result = instance.calculateWeight(itemWeight, itemQuantity);
        assertEquals(expResult, result, 0.0);
    }
    
}

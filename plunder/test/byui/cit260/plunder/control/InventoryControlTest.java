/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.Ship;
import java.util.ArrayList;
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
        double[] itemWeight = {12, 115};
        double[] itemQuantity = {1, 3};
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

    /**
     * Test of sellAll method, of class InventoryControl.
     */
    @Test
    public void testSellAll() {
        System.out.println("sellAll test 1");
        Ship ship = new Ship();
        InventoryItem item1 = new InventoryItem();
        InventoryItem item2 = new InventoryItem();

        item1.setQuantityInStock(1);
        item1.setValue(12);
        item2.setQuantityInStock(3);
        item2.setValue(115);

        ArrayList<InventoryItem> inv = new ArrayList();
        inv.add(item1);
        inv.add(item2);
        ship.setInventory(inv);
        double expResult = 357.0;
        double result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);


        System.out.println("sellAll test 2");
        inv.get(0).setValue(1);
        inv.get(0).setQuantityInStock(1);
        inv.get(1).setValue(1);
        inv.get(1).setQuantityInStock(1);
        ship.setInventory(inv);
        expResult = 2.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);
    
        System.out.println("sellAll test 3");
        inv.get(0).setValue(0);
        inv.get(0).setQuantityInStock(10);
        inv.get(1).setValue(1000);
        inv.get(1).setQuantityInStock(1);
        ship.setInventory(inv);
        expResult = 1000.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);

        System.out.println("sellAll test 4");
        inv.get(0).setValue(500);
        inv.get(0).setQuantityInStock(1);
        inv.get(1).setValue(1000);
        inv.get(1).setQuantityInStock(0);
        ship.setInventory(inv);
        expResult = 500.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);

        System.out.println("sellAll test 5");
        inv.get(0).setValue(-1);
        inv.get(0).setQuantityInStock(10);
        inv.get(1).setValue(1);
        inv.get(1).setQuantityInStock(10);
        ship.setInventory(inv);
        expResult = -1.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);

        System.out.println("sellAll test 6");
        inv.get(0).setValue(10);
        inv.get(0).setQuantityInStock(-1);
        inv.get(1).setValue(100);
        inv.get(1).setQuantityInStock(5);
        ship.setInventory(inv);
        expResult = -1.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);

        System.out.println("sellAll test 7");
        inv.get(0).setValue(100);
        inv.get(0).setQuantityInStock(5);
        inv.get(1).setValue(-1);
        inv.get(1).setQuantityInStock(10);
        ship.setInventory(inv);
        expResult = -1.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);

        System.out.println("sellAll test 8");
        inv.get(0).setValue(1);
        inv.get(0).setQuantityInStock(10);
        inv.get(1).setValue(10);
        inv.get(1).setQuantityInStock(-1);
        ship.setInventory(inv);
        expResult = -1.0;
        result = InventoryControl.sellAll(ship);
        assertEquals(expResult, result, 0.0);

    }


    /**
     * Test of howMuch method, of class InventoryControl.
     */
//    @Test
//    public void testHowMuch() {
//        System.out.println("howMuch");
//        String displayLetter = "";
//        ArrayList<InventoryItem> inventoryItems = new ArrayList();
//        int expResult = 0;
//        int result = InventoryControl.howMuch(displayLetter, inventoryItems);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
//     * Test of itemSearch method, of class InventoryControl.
//     */
//    @Test
//    public void testItemSearch() {
//        System.out.println("itemSearch");
//        String displayLetter = "";
//        ArrayList<InventoryItem> inventoryItems = new ArrayList();
//        int expResult = 0;
//        int result = InventoryControl.itemSearch(displayLetter, inventoryItems);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of changeQuantity method, of class InventoryControl.
//     */
//    @Test
//    public void testChangeQuantity() {
//        System.out.println("changeQuantity");
//        int amount = 0;
//        ArrayList<InventoryItem> inventoryItems = new ArrayList();
//        String type = "";
//        InventoryControl.changeQuantity(amount, inventoryItems, type);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
}

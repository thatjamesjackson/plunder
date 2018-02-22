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
public class InventoryControl {

    public static double calculateWeight(double[] itemWeight, double[] itemQuantity) {

// check all weights are not less than 0
        for (int i = 0; i < itemWeight.length; i++) {
            if (itemWeight[i] < 0) {
                return - 1;
            }
        }
// check all quantities are not less than 0
        for (int i = 0; i < itemQuantity.length; i++) {
            if (itemQuantity[i] < 0) {
                return - 2;
            }
        }
//this can’t go on the test table, but both arrays have to be the same length
        if (itemWeight.length != itemQuantity.length) {
            return - 3;
        }
//declare weight
        double weight = 0;

        /*calculate weight it does not matter which array 
* length you use as we just checked they were the same length*/
        for (int i = 0; i < itemWeight.length; i++) {
            weight += itemQuantity[i] * itemWeight[i];
        }
        return weight;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import java.util.Scanner;

/**
 *
 * @author abigailking
 */
public class InventoryView {
    public void display() { 
        
        boolean endView = false; 
        do{
             System.out.println(
"                           .=\"\"_;=.\n" +
"                       ,-\"_,=\"\"     `\"=.\n" +
"                       \"=._o`\"-._        `\"=.\n" +
"                           `\"=._o`\"=._      _`\"=.\n" +
"                               :=._o \"=._.\"_.-=\"'\"=.\n" +
"                           .--\" , ; `\"=._o.\" ,-\"\"\"-._ \".\n" +
"                        ._\"  ,. .` ` `` ,  `\"-._\"-._   \". '\n" +
"                      |o`\"=._` , \"` `; .\". ,  \"-._\"-._; ;\n" +
"                      | ;`-.o`\"=._; .\" ` '`.\"\\` . \"-._ /\n" +
"                      |o;    `\"-.o`\"=._``  '` \" ,__.--o;\n" +
"                      | ;     (#) `-.o `\"=.`_.--\"_o.-; ;\n" +
"                      |o;._    \"      `\".o|o_.--\"    ;o;\n" +
"                       \"=._o--._        ; | ;        ; ;\n" +
"                             =._o--._   ;o|o;     _._;o;\n" +
"                                  =._o._; | ;_.--\"o.--\"\n" +
"                                        =.o|o_.--\"\"" +
                                "========================================\n" +
                                "          What do ya want?\n" +
                                "            B - Buy\n" +
                                "            S - Sell all loot\n" +
                                "            R - Return to ship");
            String[] inputs = getInputs();
            String first = inputs[0].toUpperCase();
            if (first.length() != 1 || first.equals(" ")) {
                System.out.println("Please enter a menu item");
                continue;
            }
            
        endView = doAction(first);
    } while(endView != true);
}

    private String[] getInputs() {
        
        String[] inputs = new String[1];
        Scanner scan = new Scanner(System.in);
        inputs[0] = scan.nextLine();
        return inputs;
    }

    private boolean doAction(String input) {
        
        switch (input) {
            case "B":
                buyShop();
                break;

            case "S":
                sellShop();
                break;

            case "R":
                return true;

            default:
                System.out.println("Invalid Menu Item");

        }
        return false; 
    }

    private void buyShop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sellShop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

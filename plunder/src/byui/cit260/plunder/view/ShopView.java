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
public class ShopView {
    public void display() { 
        boolean endView = false; 
        
        do{
             System.out.println("                _____\n" +
                                "              .-\" .-. \"-.\n" +
                                "            _/ '=(0.0)=' \\_\n" +
                                "          /`   .='|m|'=.   `\\\n" +
                                "          \\________________ /\n" +
                                "      .--.__///`'-,__~\\\\\\\\~`\n" +
                                "     / /6|__\\// a (__)-\\\\\\\\\n" +
                                "     \\ \\/--`((   ._\\   ,)))\n" +
                                "     /  \\\\  ))\\  -==-  (O)(\n" +
                                "    /    )\\((((\\   .  /)))))\n" +
                                "   /  _.' /  __(`~~~~`)__\n" +
                                "  //\"\\\\,-'-\"`   `~~~~\\\\~~`\"-.\n" +
                                " //  /`\"              `      `\\\n" +
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

    private boolean doAction(String first) {
        
        return false; 
    }
    
    
}

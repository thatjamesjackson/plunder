/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.Player;
import byui.cit260.plunder.model.Ship;

/**
 *
 * @author abigailking
 */
public class ShopView extends View {


    @Override
    public String[] getInputs() {
        
        // display menu
        System.out.println("                 _____\n" +
                                "              .-\" .-. \"-.\n" +
                                "            _/ '=(0.0)=' \\_\n" +
                                "          /`   .='|m|'=.   `\\\n" +
                                "          \\________________ /\n" +
                                "      .--.__///`'-,__~\\\\~`\n" +
                                "     / /6|__\\/ a (__)-\\\\n" +
                                "     \\ \\--`((  ._\\   ,)))\n" +
                                "     /  \\\\  ))\\  -==-  (O)(\n" +
                                "    /    )\\((((\\   .  /)))))\n" +
                                "   /    _.' /  __(`~~~~`)__\n" +
                                "  //\"\\\\,-'-\"` `~~~~\\\\~~`\"-.\n" +
                                " //  /`\"              `      `\\\n" +
                                "========================================\n" +
                                "          What do ya want?\n" +
                                "            B - Buy\n" +
                                "            S - Sell all loot\n" +
                                "            R - Return to ship");
        //declare new
        String [] inputs = new String[1];
        
        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs [0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        
        switch (inputs[0]) {
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

    private void buyShop(Game game) {
        Ship ship = game.getPlayer().getShip();
        
        
    }

    private void sellShop(Game game) {
        Double gold = InventoryControl.sellAll(game.getPlayer().getShip());
        game.setMoney(game.getMoney() + gold);
    }
    
    
}

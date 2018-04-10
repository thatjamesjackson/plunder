/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.InventoryControl;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.Ship;
import exceptions.InventoryControlException;
import java.util.logging.Level;
import java.util.logging.Logger;
import plunder.Plunder;

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
"      .--.__///`'-,__~\\\\\\\\~`\n" +
"     / /6|__\\// a (__)-\\\\\\\\\n" +
"     \\ \\/--`((   ._\\   ,)))\n" +
"     /  \\\\  ))\\  -==-  (O)(\n" +
"    /    )\\((((\\   .  /)))))\n" +
"   /  _.' /  __(`~~~~`)__\n" +
"  //\"\\\\,-'-\"`   `~~~~\\\\~~`\"-.\n" +
" //  /`\"              `      `\\");
        System.out.println("========================================\n"
                + "          What do ya want?\n"
                + "            B - Buy\n"
                + "            S - Sell all yer loot\n"
                + "            Q - Return to ship");
        //declare new
        String[] inputs = new String[1];

        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        Game game = Plunder.getCurrentGame();
        switch (inputs[0]) {
            case "B":
                BuyShopView buy = new BuyShopView();
                buy.display();
                break;

            case "S": {
                try {
                    sellShop(game);
                } catch (InventoryControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    ErrorView.display(this.getClass().getName(), "Error Selling Items");
                }
            }
            break;

            case "Q":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return false;
    }


    private void sellShop(Game game) throws InventoryControlException {
        Double gold = InventoryControl.sellAll(game.getPlayer().getShip());
        game.setMoney(game.getMoney() + gold);
    }

}

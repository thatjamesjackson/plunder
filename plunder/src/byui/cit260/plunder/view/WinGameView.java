/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.InventoryItemType;
import java.util.Random;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class WinGameView extends View {
    
    @Override
    public String[] getInputs() {
        // display menu
        this.console.println(
"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
+"                               _.--.\n" +
 "                          _.-'_:-'||\n" +
 "                      _.-'_.-::::'||\n" +
 "                 _.-:'_.-::::::'  ||\n" +
 "               .'`-.-:::::::'     ||\n" +
 "              /.'`;|:::::::'      ||_\n" +
 "             ||   ||::::::'     _.;._'-._\n" +
 "             ||   ||:::::'  _.-!oo @.!-._'-.\n" +
 "             \\'.  ||:::::.-!()oo @!()@.-'_.|\n" +
 "              '.'-;|:.-'.&$@.& ()$%-'o.'|U||\n" +
 "                `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
 "                 ||-._'-.@.-'_.-' _.-o  |'||\n" +
 "                 ||=[ '-._.-/U/.-'    o |'||\n" +
 "                 || '-.]=|| |'|      o  |'||\n" +
 "                 ||      || |'|        _| ';\n" +
 "                 ||      || |'|    _.-'_.-'\n" +
 "                 |'-._   || |'|_.-'_.-'\n" +
 "                  '-._'-.|| |' `_.-'\n" +
 "                      '-.||_/.-'\n\n"
+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
+ "  Are ya gonna take the treasure for yerself?\n"
+ "  Or do ye want to share with yer crew?\n"
+ "    T - Take for yerself\n"
+ "    S - Share with yer crew\n");
        //declare new
        String [] inputs = new String[1];
        
        // retrieve input from user
        String input = this.getInput("Make yer choice: \n");
        inputs [0] = input;
        return inputs;

    }

    @Override
    public boolean doAction(String[] inputs) {
        switch (inputs[0]) {
            case "T":
                this.console.println(
                        "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "  Ye take the treasure and run to the other end of the island\n"
                        + "  but yer crew be followin right behind ye.\n"
                        + "  They aren't happy. The crew decides to maroon you here on this island.\n"
                        + "  Yer crew took all the treasure too.\n"
                        + "  There's no food on this here island. Ye starve.");
                Plunder.getCurrentGame().setEndGame(true);
                break;

            case "S":
                this.console.println(
                        "\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + " Ye all cheer and divvy up the treasure. \n"
                        + "  Ye be heavy laden with jewels. Sinching up yer belt to keep\n"
                        + "  the weight of ye booty secure.\n");
                addBooty();
                return true;
                

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        
        return true;
    }

    private void addBooty() {
        Random r = new Random();
        int jewelResult = r.nextInt(1000-1) + 1;
        int goldResult = r.nextInt(3000-1) + 1;
                
        InventoryItem jewel = Plunder.getCurrentGame().getInventory().get(InventoryItemType.jewels.ordinal());
        jewel.setQuantityInStock(jewel.getQuantityInStock() + 2000 + jewelResult);
        
        Game gold = Plunder.getCurrentGame();
        gold.setMoney(gold.getMoney() + 2000 + goldResult);
        
        this.console.println(
                          "  Lay yer eyes on yer bounty. Here in this chest\n"
                        + "  ye found " + gold.getMoney() + " gold pieces and " + jewel.getQuantityInStock() + " jewels\n"
                        + "  Carefully now as ye search the waters of Paradise. This booty\n"
                        + "  here makes ye a fair target for other pirates and such.\n");
    }
    
}

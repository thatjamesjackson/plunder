/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.InventoryItemType;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.Player;
import java.util.ArrayList;
import plunder.Plunder;

public class GameControl {

    public static Player savePlayer(String playerName) {
        //make a new player with name based on input
        System.out.println("Save Player Called");
        //fail if there is no name
        if (playerName.equals(" ") || playerName.equals("")) {
            return null;
        }
        Player player = new Player();
        player.setName(playerName);
        Plunder.setPlayer(player);
        return player;
    }

    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }
        Game game = new Game();
        game.setPlayer(player);
        Plunder.setCurrentGame(game);

        //actors are enums
//Assign an actor to the player 
        player.setActor(Actor.Captain);
        //make inventory items
        ArrayList<InventoryItem> inventory = createItems();

//Save the list of items in the game 
        game.setInventory(inventory);
        //map = create
        //Map(noOfRows, noOfColumns, items) 
        Map map = MapControl.createMap(5, 5, inventory);
        if (map == null) {
            return -1;
        }

//Assign the map to the game 
        game.setMap(map);
        return 1;
    }

    public static ArrayList<InventoryItem> createItems() {
        InventoryItem jewels = new InventoryItem();
        jewels.setInventoryType("Jewels");
        jewels.setQuantityInStock(0);
        jewels.setValue(300);
        jewels.setWeight(2);

        InventoryItem fish = new InventoryItem();
        fish.setInventoryType("Fish");
        fish.setQuantityInStock(0);
        fish.setValue(20);
        fish.setWeight(5);

        InventoryItem cotton = new InventoryItem();
        cotton.setInventoryType("Cotton");
        cotton.setQuantityInStock(0);
        cotton.setValue(50);
        cotton.setWeight(1);

        InventoryItem spices = new InventoryItem();
        spices.setInventoryType("Spices");
        spices.setQuantityInStock(0);
        spices.setValue(100);
        spices.setWeight(1);
        
        InventoryItem coconut = new InventoryItem();
        spices.setInventoryType("Coconuts");
        spices.setQuantityInStock(0);
        spices.setValue(10);
        spices.setWeight(1);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(InventoryItemType.jewels.ordinal(), jewels);
        items.add(InventoryItemType.fish.ordinal(), fish);
        items.add(InventoryItemType.cotton.ordinal(), cotton);
        items.add(InventoryItemType.coconut.ordinal(), coconut);
        items.add(InventoryItemType.spices.ordinal(), spices);

        return items;
    }

}

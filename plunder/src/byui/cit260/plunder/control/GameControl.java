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
import byui.cit260.plunder.model.NPC;
import byui.cit260.plunder.model.Player;
import byui.cit260.plunder.model.Ship;
import exceptions.GameControlException;
import exceptions.MapControlException;
import java.util.ArrayList;
import plunder.Plunder;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameControl {

    public static Player savePlayer(String playerName) throws GameControlException {
        //make a new player with name based on input

        //fail if there is no name
        if (playerName.equals(" ") || playerName.equals("")) {
            throw new GameControlException("Please enter a name for your player.");
        }
        Player player = new Player();
        player.setName(playerName);
        Plunder.setPlayer(player);
        return player;
    }

    public static int createNewGame(Player player) throws MapControlException, GameControlException {
        if (player == null) {
            throw new GameControlException("Error creating new game, please try again.");
        }
        Game game = new Game();
        game.setPlayer(player);
        Plunder.setCurrentGame(game);

        //actors are enums
        //Assign an actor to the player 
        Actor captain = new Actor();
        captain.setCoordinates(new Point(0, 0));
        captain.setName(player.getName());
        captain.setDescription("A pirate of some renown");
        player.setActor(captain);
        //make inventory items
        ArrayList<InventoryItem> inventory = createItems();

        //make npc list
        NPC[] npc = CrewControl.createNPC();
        game.setNPC(npc);

        
        //map = create
        //Map(noOfRows, noOfColumns, items) 
        Map map = MapControl.createMap(5, 5, inventory);
        if (map == null) {
            throw new MapControlException("Error loading in map.");
        }

        //Assign the map to the game 
        game.setMap(map);

        //give player a ship and in inventory
        Ship ship = new Ship();
        ship.setArmor(1);
        ship.setCarryWeight(300);
        ship.setShipMaxHealth(100);
        ship.setShipHealth(100);
        ship.setShipRepair(5);
        ship.setName("The Salty Dog");
        ship.setShipAttack(10);

        ship.setInventory(inventory);

        player.setShip(ship);

        return 1;
    }

    public static ArrayList<InventoryItem> createItems() {
        //start the player off with a few items
        InventoryItem jewels = new InventoryItem();
        jewels.setInventoryType("Jewels");
        jewels.setTypeAbr("J");
        jewels.setQuantityInStock(2);
        jewels.setValue(300);
        jewels.setWeight(2);

        InventoryItem fish = new InventoryItem();
        fish.setInventoryType("Fish");
        fish.setTypeAbr("F");
        fish.setQuantityInStock(50);
        fish.setValue(20);
        fish.setWeight(1);

        InventoryItem cotton = new InventoryItem();
        cotton.setInventoryType("Cotton");
        cotton.setTypeAbr("C");
        cotton.setQuantityInStock(5);
        cotton.setValue(50);
        cotton.setWeight(1);

        InventoryItem spices = new InventoryItem();
        spices.setInventoryType("Spices");
        spices.setTypeAbr("S");
        spices.setQuantityInStock(3);
        spices.setValue(100);
        spices.setWeight(1);

        InventoryItem coconut = new InventoryItem();
        coconut.setInventoryType("Coconuts");
        coconut.setTypeAbr("O");
        coconut.setQuantityInStock(10);
        coconut.setValue(10);
        coconut.setWeight(1);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(InventoryItemType.fish.ordinal(), fish);
        items.add(InventoryItemType.jewels.ordinal(), jewels);
        items.add(InventoryItemType.cotton.ordinal(), cotton);
        items.add(InventoryItemType.coconut.ordinal(), coconut);
        items.add(InventoryItemType.spices.ordinal(), spices);

        return items;
    }

    public static void saveGame(Game game, String filePath) throws GameControlException {
//        if invalid a game or filePath is passed to the method then
//        throw a new GameControlException
//        endIf
//        create a new FileOutputStream for the filePath
//        create a new ObjectOutputStream from the FileOutputStream
//        write the game object to the ObjectOutputStream

        if (game == null || filePath.length() < 1) {
            throw new GameControlException("Error saving game, please try again.");
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(game);
        } catch (IOException ex) {
            throw new GameControlException(ex.getMessage());
        }

    }

    public static void getGame(Game game, String filePath) throws GameControlException {
//    if the filePath is null then
//    throw a new GameControlException
//    endIf

//    create a new FileInputStream for the filePath
//    create a new ObjectInputStream from the FileOutputStream
//    game = call ObjectInputStream’s readObject() method
//    set the currentGame attribute in the main class to the game object
//    set the player attribute in the main class to the player object saved in the game object
//    return game
        if (filePath == null) {
            throw new GameControlException("Could not grab file, path is empty.");
        }

//        try (FileInputStream in = new FileInputStream(filePath)){
//            try (ObjectInputStream inObject = new ObjectInputStream(in)){
//                game = (Game) inObject.readObject();
//                Plunder.setCurrentGame(game);
//                Plunder.setPlayer(game.getPlayer());
//            } catch (ClassNotFoundException ce){
//                throw new GameControlException(ce.getMessage());
//            } 
//        } catch (IOException ex){
//                throw new GameControlException(ex.getMessage());
//        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            game = (Game) in.readObject();

            Plunder.setCurrentGame(game);
            Plunder.setPlayer(game.getPlayer());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new GameControlException(ex.getMessage());
        } catch (ClassNotFoundException ce) {
            throw new GameControlException(ce.getMessage());
        }

    }

}

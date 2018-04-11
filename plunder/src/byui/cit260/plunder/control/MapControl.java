/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.Location;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.CombatScene;
import byui.cit260.plunder.model.DecisionScene;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.InventoryItemType;
import byui.cit260.plunder.model.RegularScene;
import byui.cit260.plunder.model.ResourceScene;
import byui.cit260.plunder.model.SceneType;
import byui.cit260.plunder.model.Ship;
import byui.cit260.plunder.model.ShipType;
import byui.cit260.plunder.view.CalmOceanView;
import byui.cit260.plunder.view.CombatView;
import byui.cit260.plunder.view.GameMenuView;
import byui.cit260.plunder.view.RoughOceanView;
import byui.cit260.plunder.view.ShopView;
import byui.cit260.plunder.view.WinGameView;
import exceptions.InventoryControlException;
import exceptions.MapControlException;
import java.awt.Point;
import java.util.ArrayList;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class MapControl {
public static void travel(Actor actor, Map map, int y, int x) throws MapControlException, InventoryControlException {

        if (y < 0 || y > map.getRowCount() - 1 || x < 0 || x > map.getColumnCount() - 1) {
            throw new MapControlException("You cannot go that way");
        }
        Ship ship = Plunder.getCurrentGame().getPlayer().getShip();
        if (InventoryControl.calculateWeight(ship) > Plunder.getCurrentGame().getPlayer().getShip().getCarryWeight()){
            throw new InventoryControlException("The ship be too heavy, toss some cargo overboard");
                  }
                actor.setCoordinates(new Point(x, y));
                Location loc = Plunder.getCurrentGame().getMap().getLocation()[y][x];
                loc.setVisited(true);

    }
    public static Map createMap(int numRows, int numColumns, ArrayList items) throws MapControlException {
        //check invalid input
        if (numRows < 1 || numColumns < 1) {
            throw new MapControlException("Cannot have less than one row or column");
        }
        if (items.size() < 1) {
            throw new MapControlException("Items array cannot be fewer than one element");
        }
        //new map
        Map map = new Map();
        map.setRowCount(numRows);
        map.setColumnCount(numColumns);
        //create locations array
        Location[][] locations = createLocations(numRows, numColumns);
        //set locations to map
        map.setLocation(locations);

        //make scenes
        RegularScene[] scenes = createScenes(items);
//        //make questions
//        DecisionScene[] choices = createQuestions();
//        //assign items and questions to scenes
//        assignQuestionsToScenes(choices, scenes);

        //put scenes into locations
        assignScenesToLocations(scenes, locations);

        return map;
    }

    private static Location[][] createLocations(int numRows, int numColumns) throws MapControlException {
//        System.out.println("createLocations called");

        if (numRows < 1 || numColumns < 1) {
            throw new MapControlException("Cannot have less than one row or column");
        }

        Location[][] locations = new Location[numRows][numColumns];
        for (int i = 0; i < locations.length; i++) {
            for (int f = 0; f < locations[i].length; f++) {
                Location currentLocation = new Location();
                currentLocation.setRow(i);
                currentLocation.setColumn(f);
                currentLocation.setVisited(false);

                locations[i][f] = currentLocation;
            }
        }
        //start location is visited
        locations[0][0].setVisited(true);

        return locations;
    }

    private static RegularScene[] createScenes(ArrayList<InventoryItem> items) {
        // System.out.println("createQuestions called");

        RegularScene[] scenes = new RegularScene[SceneType.values().length];

        DecisionScene islandRegular = new DecisionScene(
                "The warm welcoming sands stretch out before you. A few trees offer shade and coconuts.",
                "...",
                SceneType.islandRegular.ordinal()
                );
        scenes[SceneType.islandRegular.ordinal()] = islandRegular;

        ResourceScene islandResourceScene = new ResourceScene(
                "While you are on the island, you see some useful items here.",
                ".T.",
                SceneType.islandResource.ordinal(),
                items.get(InventoryItemType.coconut.ordinal()));
        scenes[SceneType.islandResource.ordinal()] = islandResourceScene;
        
        CombatScene combatFBoat = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.fishingBoat.ordinal()),
                "A fishing vessel lies over yonder.",
                "~p~",
                SceneType.fishingBoat.ordinal());
        scenes[SceneType.fishingBoat.ordinal()] = combatFBoat;
        
        CombatScene combatSBoat = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.sailBoat.ordinal()),
                "A sailing boat aproaches.",
                "~p~",
                SceneType.sailBoat.ordinal());
        scenes[SceneType.sailBoat.ordinal()] = combatSBoat;
        
        CombatScene combatClipper = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.clipper.ordinal()),
                "A clipper speeds across the water.",
                "~p~",
                SceneType.clipper.ordinal());
        scenes[SceneType.clipper.ordinal()] = combatClipper;

        CombatScene combatFrigate = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.frigate.ordinal()),
                "A frigate aproaches and fires a warning shot.",
                "~p~",
                SceneType.frigate.ordinal());
        scenes[SceneType.frigate.ordinal()] = combatFrigate;

        CombatScene combatGunBoat = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.gunBoat.ordinal()),
                "A gunboat sets course for you.",
                "~p~",
                SceneType.gunBoat.ordinal());
        scenes[SceneType.gunBoat.ordinal()] = combatGunBoat;

        CombatScene combatManOfWar = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.manOfWar.ordinal()),
                "A Man of War has ye in it's sights, prepare for a tough fight.",
                "~p~",
                SceneType.manOfWar.ordinal());
        scenes[SceneType.manOfWar.ordinal()] = combatManOfWar;
        
        CombatScene combatSeaMonster = new CombatScene(
                CombatControl.enemyShipConstructor(ShipType.seaMonster.ordinal()),
                "From the depths you see a terrifying sea monster rise and open its jaws.",
                "~S~",
                SceneType.seaMonster.ordinal());
        scenes[SceneType.seaMonster.ordinal()] = combatSeaMonster;

        DecisionScene shopIsland = new DecisionScene(
                "A welcoming merchant offers ye up a trade.",
                ".@.",
                SceneType.shopIsland.ordinal());
        scenes[SceneType.shopIsland.ordinal()] = shopIsland;

        DecisionScene treasure = new DecisionScene(
                "Glittering gold, sparkling jewels, and heavy too. For a pirate, this be the most beautiful sight in the world.",
                "<x>",
                SceneType.treasure.ordinal());
        scenes[SceneType.treasure.ordinal()] = treasure;

        ResourceScene oceanResource = new ResourceScene(
                "There be many fish in these waters.",
                "<#<",
                SceneType.oResource.ordinal(),
               items.get(InventoryItemType.fish.ordinal()));
        scenes[SceneType.oResource.ordinal()] = oceanResource;
        
        //oceanResource.setResource(items.get(InventoryItemType.fish.ordinal()));

        ResourceScene roughOcean = new ResourceScene(
                "Careful now, we be in some rough waters.",
                "###",
                SceneType.oRough.ordinal(),
                items.get(InventoryItemType.fish.ordinal()));
        scenes[SceneType.oRough.ordinal()] = roughOcean;
        
        ResourceScene calmOcean = new ResourceScene(
                "Here there be no comotion on the ocean. Calm waters be upon us.",
                "~~~",
                SceneType.oCalm.ordinal(),
                items.get(InventoryItemType.fish.ordinal()));
        scenes[SceneType.oCalm.ordinal()] = calmOcean;

        return scenes;
    }

    private static void assignScenesToLocations(RegularScene[] scenes, Location[][] locations) {
        //creates the map [y][x] coodinates
        locations[0][0].setScene(scenes[SceneType.oCalm.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.oResource.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.gunBoat.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.oRough.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.oCalm.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.shopIsland.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.fishingBoat.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.oResource.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.islandResource.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.oCalm.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.clipper.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.sailBoat.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.manOfWar.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.oResource.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.seaMonster.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.oRough.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.islandRegular.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.islandResource.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.seaMonster.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.islandRegular.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.islandResource.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.islandResource.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.frigate.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.seaMonster.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.treasure.ordinal()]);
    }

}

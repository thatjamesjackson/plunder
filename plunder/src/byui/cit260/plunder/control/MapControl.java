/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.CombatScene;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.InventoryItemType;
import byui.cit260.plunder.model.Location;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.Question;
import byui.cit260.plunder.model.RegularScene;
import byui.cit260.plunder.model.ResourceScene;
import byui.cit260.plunder.model.SceneType;
import byui.cit260.plunder.model.ShipType;
import byui.cit260.plunder.model.ShopScene;
import java.util.ArrayList;

/**
 *
 * @author abigailking
 */
public class MapControl {

    public static Map createMap(int numRows, int numColumns, ArrayList items) {
        //check invalid input
        if (numRows < 1 || numColumns < 1) {
            return null;
        }
        if (items.size() < 1) {
            return null;
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
        //make questions
        Question[] questions = createQuestions();
        //assign items and questions to scenes
        assignQuestionsToScenes(questions, scenes);
        assignItemsToScenes(items, scenes);

        //put scenes into locations
        assignScenesToLocations(scenes, locations);

        return map;
    }

    private static Location[][] createLocations(int numRows, int numColumns) {
//        System.out.println("createLocations called");

        if (numRows < 1 || numColumns < 1) {
            return null;
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

        return locations;
    }

    private static RegularScene[] createScenes(ArrayList<InventoryItem> items) {
        // System.out.println("createQuestions called");

        RegularScene[] scenes = new RegularScene[SceneType.values().length];

        RegularScene islandRegular = new RegularScene();
        islandRegular.setDescription("The warm welcoming sands stretch out before you. A few trees offer shade and coconuts.");
        islandRegular.setSymbol("...");
        scenes[SceneType.islandRegular.ordinal()] = islandRegular;

        ResourceScene islandResourceScene = new ResourceScene();
        islandResourceScene.setDescription("While you are on the island, you see some useful items here.");
        islandResourceScene.setResource(items.get(InventoryItemType.coconut.ordinal()));
        islandResourceScene.setSymbol(".T.");
        scenes[SceneType.islandResource.ordinal()] = islandResourceScene;

        CombatScene combatFBoat = new CombatScene();
        combatFBoat.setDescription("A fishing vessel lies over yonder");
        combatFBoat.setOpponent(CombatControl.enemyShipConstructor(ShipType.fishingBoat.ordinal()));
        combatFBoat.setSymbol("~p~");
        scenes[SceneType.fishingBoat.ordinal()] = combatFBoat;

        CombatScene combatSBoat = new CombatScene();
        combatSBoat.setDescription("A sailing boat aproaches");
        combatSBoat.setOpponent(CombatControl.enemyShipConstructor(ShipType.sailBoat.ordinal()));
        combatSBoat.setSymbol("~p~");
        scenes[SceneType.sailBoat.ordinal()] = combatSBoat;

        CombatScene combatClipper = new CombatScene();
        combatClipper.setDescription("A clipper speeds across the water");
        combatClipper.setOpponent(CombatControl.enemyShipConstructor(ShipType.clipper.ordinal()));
        combatClipper.setSymbol("~p~");
        scenes[SceneType.clipper.ordinal()] = combatClipper;

        CombatScene combatFrigate = new CombatScene();
        combatFrigate.setDescription("A frigate aproaches and fires a warning shot");
        combatFrigate.setOpponent(CombatControl.enemyShipConstructor(ShipType.frigate.ordinal()));
        combatFrigate.setSymbol("~p~");
        scenes[SceneType.frigate.ordinal()] = combatFrigate;

        CombatScene combatGunBoat = new CombatScene();
        combatGunBoat.setDescription("A Gunboat sets course for you");
        combatGunBoat.setOpponent(CombatControl.enemyShipConstructor(ShipType.gunBoat.ordinal()));
        combatGunBoat.setSymbol("~p~");
        scenes[SceneType.gunBoat.ordinal()] = combatGunBoat;

        CombatScene combatManOfWar = new CombatScene();
        combatManOfWar.setDescription("A Man of War has ye in it's sights, prepare for a tough fight");
        combatManOfWar.setOpponent(CombatControl.enemyShipConstructor(ShipType.manOfWar.ordinal()));
        combatManOfWar.setSymbol("~p~");
        scenes[SceneType.manOfWar.ordinal()] = combatManOfWar;

        CombatScene combatSeaMonster = new CombatScene();
        combatSeaMonster.setDescription("From the depths you see a terrifying sea monster rise and open its jaws.");
        combatSeaMonster.setOpponent(CombatControl.enemyShipConstructor(ShipType.seaMonster.ordinal()));
        combatSeaMonster.setSymbol("~S~");
        scenes[SceneType.seaMonster.ordinal()] = combatSeaMonster;

        ShopScene shopIsland = new ShopScene();
        shopIsland.setDescription("A welcoming merchant offers ye up a trade.");
        shopIsland.setSymbol(".@.");
        // shopIsland.setUpgrade();
        scenes[SceneType.shopIsland.ordinal()] = shopIsland;

        ResourceScene treasure = new ResourceScene();
        treasure.setDescription("Glittering gold, sparkling jewels, and heavy too. For a pirate, this be the most beautiful sight in the world.");
        treasure.setResource(items.get(InventoryItemType.jewels.ordinal()));
        treasure.setSymbol("...");
        scenes[SceneType.treasure.ordinal()] = treasure;

        ResourceScene oceanResource = new ResourceScene();
        oceanResource.setDescription("There be many fish in these waters");
        oceanResource.setResource(items.get(InventoryItemType.fish.ordinal()));
        oceanResource.setSymbol("<#<");
        scenes[SceneType.oResource.ordinal()] = oceanResource;

        RegularScene roughOcean = new RegularScene();
        roughOcean.setDescription("Careful now, we be in some rough waters.");
        roughOcean.setSymbol("###");
        scenes[SceneType.oRough.ordinal()] = roughOcean;

        RegularScene calmOcean = new RegularScene();
        calmOcean.setDescription("Here there be no comotion on the ocean. Calm waters be upon us.");
        calmOcean.setSymbol("~~~");
        scenes[SceneType.oCalm.ordinal()] = calmOcean;

        return null;
    }

    private static Question[] createQuestions() {
        // System.out.println("createQuestions called");

        Question[] scenes = new Question[9];

        return null;
    }

    private static void assignQuestionsToScenes(Question[] questions, RegularScene[] scenes) {
        System.out.println("assignQuestionsToScenes called");
    }

    private static void assignItemsToScenes(ArrayList items, RegularScene[] scenes) {
        System.out.println("assignItemsToScenes called");
    }

    private static void assignScenesToLocations(RegularScene[] scenes, Location[][] locations) {
        //creates the map [x][y]
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

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

        if (numRows < 1 || numColumns < 1){
            return null;
        }
        
        Location[][] locations = new Location[numRows][numColumns];
        for (int i = 0; i < locations.length; i++){
            for (int f = 0; f < locations[i].length; f++){
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
       
       RegularScene[] scenes = new RegularScene[9];
       
       RegularScene islandRegular = new RegularScene();
       islandRegular.setDescription("The warm welcoming sands stretch out before you. A few trees offer shade and coconuts.");
       scenes[SceneType.islandRegular.ordinal()] = islandRegular;
       
       ResourceScene islandResourceScene = new ResourceScene();
       islandResourceScene.setDescription("While you are on the island, you see some useful items here.");
       islandResourceScene.setResource(items.get(InventoryItemType.fish.ordinal()));
       scenes[SceneType.islandResource.ordinal()] = islandResourceScene;
       
       CombatScene combatSeaMonster = new CombatScene();
       combatSeaMonster.setDescription("From the depths you see a terrifying sea monster rise and open its jaws.");
       combatSeaMonster.setOpponent(ShipType.seaMonster);
       scenes[SceneType.seaMonster.ordinal()] = combatSeaMonster;
       
       ShopScene shopIsland = new ShopScene();
       shopIsland.setDescription("A welcoming merchant offers ye up a trade.");
       // shopIsland.setUpgrade();
       scenes[SceneType.shopIsland.ordinal()] = shopIsland;
       
       ResourceScene treasure = new ResourceScene();
       treasure.setDescription("Glittering gold, sparkling jewels, and heavy too. For a pirate, this be the most beautiful sight in the world.");
       treasure.setResource(items.get(InventoryItemType.jewels.ordinal()));
       scenes[SceneType.treasure.ordinal()] = treasure;
       
       RegularScene roughOcean = new ResourceScene();
       roughOcean.setDescription("Careful now, we be in some rough waters.");
       scenes[SceneType.oRough.ordinal()] = roughOcean;
       
       RegularScene calmOcean = new ResourceScene();
       calmOcean.setDescription("Here there be no comotion on the ocean. Calm waters be upon us.");
       scenes[SceneType.oCalm.ordinal()] = calmOcean;
       
       return null;
    }

    private static Question[] createQuestions() {
        System.out.println("createQuestions called");
        return null;}

    private static void assignQuestionsToScenes(Question[] questions, RegularScene[] scenes) {
        System.out.println("assignQuestionsToScenes called");
       }

    private static void assignItemsToScenes(ArrayList items, RegularScene[] scenes) {
      System.out.println("assignItemsToScenes called");
       }

    private static void assignScenesToLocations(RegularScene[] scenes, Location[][] locations) {
         System.out.println("assignScenesToLocations called");
       }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Location;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.Question;
import byui.cit260.plunder.model.RegularScene;
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
        RegularScene[] scenes = createScenes();
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
        System.out.println("createLocations called");
        return null;
    }

    private static RegularScene[] createScenes() {
       System.out.println("createQuestions called");
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

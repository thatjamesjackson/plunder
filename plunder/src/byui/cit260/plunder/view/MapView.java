/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.Location;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.SceneType;
import plunder.Plunder;

/**
 *
 * @author James
 */
public class MapView {

    public MapView() {
    }

    public void displayMapView() {
        Map map = Plunder.getCurrentGame().getMap();
        Location[][] locations = map.getLocation();
        //map is 5x5 in 3X1 squares
        //using x and y coordinates
        //21 total map length in chars
        System.out.print("\n---------------------\n");
        for (int y = locations.length; y > 0; y--) {
            System.out.print("|");
            for (int x = locations[y].length; x > 0; x--) {
//                if (locations[y][x].getVisited() == true) {
                    System.out.print(locations[y][x].getScene().getSymbol());
//                }
//            else{
//                    System.out.print("???");
//                    }
            System.out.print("|");
        }
        System.out.println("\n---------------------\n");

    }

}
}

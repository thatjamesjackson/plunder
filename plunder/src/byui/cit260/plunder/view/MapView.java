/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.plunder.view;
import byui.cit260.plunder.model.Location;
import byui.cit260.plunder.model.Map;
import java.awt.Point;
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
        System.out.print("\n-------------------------------\n");
        //count backwards to go down for y coordinates
        for (int y = locations.length - 1; y >= 0; y--) {
            System.out.print("|");
            //count up to go across for x coordinates
            for (int x = 0; x < locations[y].length; x++) {
//                if (locations[y][x].getVisited() == true) {
            Point here = Plunder.getCurrentGame().getPlayer().getActor().getCoordinates();
                  if ((int)here.getX() == x && (int)here.getY() == y){
                      System.out.print("[" + locations[y][x].getScene().getSymbol() + "]");
                  }
                  else{
                    System.out.print(" " + locations[y][x].getScene().getSymbol() + " ");
                  }
//                }
//            else{
//                    System.out.print(" ??? ");
//                    }
            System.out.print("|");
        }
        System.out.print("\n-------------------------------\n");

    }

}
}

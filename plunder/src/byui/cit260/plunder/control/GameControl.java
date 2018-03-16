/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Player;
import plunder.Plunder;


public class GameControl {
    public static Player savePlayer(String playerName) {
        //make a new player with name based on input
        System.out.println("Save Player Called");
        //fail if there is no name
        if (playerName.equals(" ")||playerName.equals("") ) {
        return null;
        }
        Player player = new Player();
        player.setName(playerName);
        Plunder.setPlayer(player);
        return player;
    }

    public static void createNewGame(Player player) {
//       if (player == null)
//return -1
//game = create 
//a
// new Game
// object 
//Save a reference to the Player object in the game
//Save a reference to the game in the 
//main class 
//actors = createActors() 
//Save the list of actors in the Game object 
//Assign an actor to the player 
//items = create
//Items() 
//Save the list of items in the game 
//map = create
//Map(noOfRows, noOfColumns, items) 
//IF map == null THEN 
//   RETURN -1 
//ENDIF 
//Assign the map to the game 
//RETURN 1 // indicates success 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Player;
import plunder.Plunder;

/**
 *
 * @author abigailking
 */
public class GameControl {
    public static Player savePlayer(String playerName) {
        System.out.println("Save Player Called");
        if (playerName.equals(" ")||playerName.equals("") ) {
        return null;
        }
        Player player = new Player();
        player.setName(playerName);
        Plunder.setPlayer(player);
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("create new game called");
    }
}

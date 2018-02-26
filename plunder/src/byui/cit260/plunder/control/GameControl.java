/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.control;

import byui.cit260.plunder.model.Player;

/**
 *
 * @author abigailking
 */
public class GameControl {
    public static Player savePlayer(String playerName) {
        System.out.println("Save Player Called");
        Player player = new Player();
        player.setName(playerName);
//        player.setBestTime(9999.99);
        return player;
    }
}

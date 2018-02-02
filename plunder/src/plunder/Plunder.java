/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plunder;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.Player;

/**
 *
 * @author James
 */
public class Plunder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        playerOne.setName("John");
        playerOne.setBestTime(9999.99);
        
        Game gameOne = new Game();
        gameOne.setTotalTime(1);
        gameOne.setMoney(100);
        gameOne.setPlayer(playerOne);
        gameOne.setProgress(2);
                
          
        System.out.println(playerOne.toString());
        System.out.println(gameOne.toString());
        System.out.println(Actor.Captain.toString());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plunder;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.Player;
import byui.cit260.plunder.model.Ship;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.Location;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.NPC;
import byui.cit260.plunder.model.Question;

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
        
        Ship shipOne = new Ship("Salty Dog", 100, 500, 50, 10);
        
        Map mapMain = new Map();
        mapMain.setDescription("");
        mapMain.setRowCount(2);
        mapMain.setColumnCount(2);
        mapMain.setCurrentRow(2);
        mapMain.setCurrentColumn(2);
        
        Location locationOne = new Location();
        locationOne.setRow(2);
        locationOne.setColumn(2);
        locationOne.setVisited(true);
        
        InventoryItem itemOne = new InventoryItem();
        itemOne.setInventoryType("weapon");
        itemOne.setQuantityInStock(1);
        itemOne.setValue(200);
        itemOne.setWeight(100);
        
        NPC npcOne = new NPC();
        npcOne.setIsCrew(true);
        npcOne.setCrewAttack(3);
        npcOne.setCrewRepair(2);
        
        Question questionOne = new Question();
        questionOne.setAskNPC("Have you been here before?");
        questionOne.setNpcResponse("Yes, I know these seas well.");
        questionOne.setIsAsked(true);
         
        System.out.println(playerOne.toString());
        System.out.println(gameOne.toString());
        System.out.println(Actor.Captain.toString());
        System.out.println(shipOne.toString());
        System.out.println(mapMain.toString());
        System.out.println(locationOne.toString());
        System.out.println(itemOne.toString());
        System.out.println(npcOne.toString());
        System.out.println(questionOne.toString());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plunder;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.CombatScene;
import byui.cit260.plunder.model.Decision;
import byui.cit260.plunder.model.DecisionScene;
import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.InventoryItem;
import byui.cit260.plunder.model.Player;
import byui.cit260.plunder.model.RegularScene;
import byui.cit260.plunder.model.ResourceScene;
import byui.cit260.plunder.model.Ship;
import byui.cit260.plunder.model.Trap;

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
        
        Ship shipOne = new Ship();
        shipOne.setName( "Salty Dog" );
        shipOne.setShipAttack(100);
        shipOne.setCarryWeight(500);
        shipOne.setArmor(50);
        shipOne.setShipRepair(10);
       
        RegularScene sceneR = new RegularScene();
        sceneR.setDescription("This is regular");
        
        CombatScene sceneC = new CombatScene();
        sceneC.setDescription("This is combat");
        sceneC.setOpponent(shipOne);
        
        Decision resultOne = new Decision();
        resultOne.setResult("YOU LOSE");
        
        Decision resultTwo = new Decision();
        resultTwo.setResult("You get hit by some darts");
        
        DecisionScene sceneD = new DecisionScene();
        sceneD.setDescription("a ship blocks your path");
        sceneD.setConsequnce(resultOne);
        sceneD.setAsk("Run Away?");
        
        Trap sceneT = new Trap();
        sceneT.setDescription("you hear a click");
        sceneT.setAsk("duck?");
        sceneT.setConsequnce(resultTwo);
        sceneT.setLostHealth(12);
        
        
        
        ResourceScene sceneRe = new ResourceScene();
        sceneRe.setAmount(100);
        sceneRe.setDescription("You find some fish");
        
        
        
        System.out.println(playerOne.toString());
        System.out.println(gameOne.toString());
        System.out.println(Actor.Captain.toString());
        System.out.println(shipOne.toString());
        System.out.println(sceneR.toString());
        System.out.println(sceneC.toString());
        System.out.println(sceneD.toString());
        System.out.println(resultOne.toString());
        System.out.println(sceneT.toString());
       
    }
    
}

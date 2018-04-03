/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.SceneType;
import java.awt.Point;
import plunder.Plunder;

/**
 *
 * @author James
 */
public class GameMenuView extends View {

    public GameMenuView() {

    }

    @Override
    public String[] getInputs() {
        //declare new
        String[] inputs = new String[1];
        MapView mapView = new MapView();
        mapView.displayMapView();
        // show menu options
        System.out.println("\n"
                + "  N - Travel North\n"
                + "  W - Travel West\n"
                + "  E - Travel East\n"
                + "  S - Travel South\n"
                + "  I - Check Inventory\n"
                + "  C - Check Crew\n"
                + "  B - Check Ship\n"
                + "  P - Explore\n"
                + "  H - Help\n"
                + "  V - Save\n"
                + "  X - Exit");

        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        Actor actor = Plunder.getPlayer().getActor();
        switch (inputs[0]) {
            case "N":
                travel(actor, (int) actor.getCoordinates().getY() + 1, (int) actor.getCoordinates().getX());
                break;

            case "W":
                travel(actor, (int) actor.getCoordinates().getY(), (int) actor.getCoordinates().getX() - 1);
                break;

            case "E":
                travel(actor, (int) actor.getCoordinates().getY(), (int) actor.getCoordinates().getX() + 1);
                break;

            case "S":
                travel(actor, (int) actor.getCoordinates().getY() - 1, (int) actor.getCoordinates().getX());
                break;

            case "I":
                this.checkInventory();
                break;

            case "C":
                checkCrew();
                break;

            case "B":
                checkShip();
                break;

            case "P":
                doExplore(actor);
                break;

            case "H":
                loadHelp();
                break;

            case "V":
                saveGame();
                break;

            case "X":
                return true;

            default:
                System.out.println("Invalid Menu Item");

        }
        return false;
    }

    private void checkInventory() {
        System.out.println("Let's see what we have here on the boat");

        InventoryView checkInventory = new InventoryView();
        checkInventory.display();
    }

    private void checkCrew() {
        System.out.println("\nAttention! Sound off");
        //begin placeholder NPCS
//        NPC npc1 = new NPC();
//                npc1.setIsCrew(true);
//                npc1.setCrewAttack(100);
//                npc1.setCrewRepair(100);
//                npc1.setJob("Gunner");
//                npc1.setName("Bob");
//                npc1.setTalk("I ain't got nothin");
//                    
//                NPC npc2 = new NPC();
//                npc2.setIsCrew(false);
//                npc2.setCrewAttack(100);
//                npc2.setCrewRepair(100);
//                npc2.setJob("Gunner");
//                npc2.setName("NOT CREW");
//                    
//                NPC npc3 = new NPC();
//                npc3.setIsCrew(true);
//                npc3.setCrewAttack(100);
//                npc3.setCrewRepair(100);
//                npc3.setJob("Carpenter");
//                npc3.setName("Steven");
//                npc3.setTalk("I ain't got nothin neither");
//                
//                NPC[] arrayNPC = {npc1, npc2, npc3};
//                //end placeholder NPCs
//                
        CrewView crewView = new CrewView();
        crewView.display();
    }

    private void checkShip() {
        System.out.println("Our ship looks yar");
    }

    private void doExplore(Actor actor) {
        System.out.println("Here be water");
        int playerX = (int) actor.getCoordinates().getX();
        int playerY = (int) actor.getCoordinates().getY();
        int type = Plunder.getCurrentGame().getMap().getLocation()[playerY][playerX].getScene().getType();
        //switch statement is incompatible with ordinal so multiple if statments required

        if (type == SceneType.islandRegular.ordinal()) {
            
        }

        if (type == SceneType.islandResource.ordinal()) {

        }
        if(type == SceneType.seaMonster.ordinal()){
        
        }
        if(type == SceneType.fishingBoat.ordinal()){
        
        }
        if(type == SceneType.sailBoat.ordinal()){
        
        }
        
        if(type == SceneType.clipper.ordinal()){
        
        }
        
        if(type == SceneType.frigate.ordinal()){
        
        }
        
        if(type == SceneType.manOfWar.ordinal()){
        
        }
        
        if(type == SceneType.gunBoat.ordinal()){
        
        }
        if(type == SceneType.shopIsland.ordinal()){
            ShopView shop = new ShopView();
        shop.display();
        }
        
        if (type == SceneType.treasure.ordinal()) {

        }

        if (type == SceneType.oRough.ordinal()) {

        }

        if (type == SceneType.oCalm.ordinal()) {

        }
        if(type == SceneType.usOcean.ordinal()){
        
        }
        if(type == SceneType.oResource.ordinal()){
        
        }
        if(type == SceneType.usLand.ordinal()){
        
        }
        
        
        

    }

    private void loadHelp() {
        HelpMenuView gameHelp = new HelpMenuView();

        gameHelp.display();
    }

    private void saveGame() {

    }

    private void travel(Actor actor, int y, int x) {
        actor.setCoordinates(new Point(x, y));

    }

}

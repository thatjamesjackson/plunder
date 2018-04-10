/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.control.MapControl;
import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.SceneType;
import plunder.Plunder;
import exceptions.MapControlException;
import exceptions.InventoryControlException;

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
        this.console.println("\n"
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
                + "  Q - Quit");

        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        Map map = Plunder.getCurrentGame().getMap();
        Actor actor = Plunder.getPlayer().getActor();
        switch (inputs[0]) {
            case "N": {
                try {
                    MapControl.travel(actor, map, (int) actor.getCoordinates().getY() + 1, (int) actor.getCoordinates().getX());
                } catch (MapControlException|InventoryControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
            }
            break;

            case "W": {
                try {
                    MapControl.travel(actor, map, (int) actor.getCoordinates().getY(), (int) actor.getCoordinates().getX() - 1);
                } catch (MapControlException|InventoryControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
            }
            break;

            case "E": {
                try {
                   MapControl.travel(actor, map, (int) actor.getCoordinates().getY(), (int) actor.getCoordinates().getX() + 1);
                } catch (MapControlException|InventoryControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
            }
            break;

            case "S": {
                try {
                    MapControl.travel(actor, map, (int) actor.getCoordinates().getY() - 1, (int) actor.getCoordinates().getX());
                } catch (MapControlException|InventoryControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    return false;
                }
            }
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

            case "Q":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid Menu Item");

        }
        return false;
    }

    private void checkInventory() {
        this.console.println("Let's see what we have here on the boat");

        InventoryView checkInventory = new InventoryView();
        checkInventory.display();
    }

    private void checkCrew() {
        this.console.println("\nAttention! Sound off");
        CrewView crewView = new CrewView();
        crewView.display();
    }

    private void checkShip() {
        this.console.println("Our ship looks yar");
    }

    private void doExplore(Actor actor) {
        int playerX = (int) actor.getCoordinates().getX();
        int playerY = (int) actor.getCoordinates().getY();
        int type = Plunder.getCurrentGame().getMap().getLocation()[playerY][playerX].getScene().getType();
        //switch statement is incompatible with ordinal so multiple if statments required

        if (type == SceneType.islandRegular.ordinal()) {
            
        }

        if (type == SceneType.islandResource.ordinal()) {

        }
        if (type == SceneType.fishingBoat.ordinal()
                || type == SceneType.seaMonster.ordinal()
                || type == SceneType.sailBoat.ordinal()
                || type == SceneType.clipper.ordinal()
                || type == SceneType.frigate.ordinal()
                || type == SceneType.gunBoat.ordinal()
                || type == SceneType.manOfWar.ordinal()) {

            CombatView combat = new CombatView();
            combat.display();

        }
        if (type == SceneType.shopIsland.ordinal()) {
            ShopView shop = new ShopView();
            shop.display();
        }

        if (type == SceneType.treasure.ordinal()) {
            TrapView trap = new TrapView();
            trap.display();
        }

        if (type == SceneType.oRough.ordinal()) {

        }

        if (type == SceneType.oCalm.ordinal()) {
            CalmOceanView calm = new CalmOceanView();
            calm.display();
        }
        
        if (type == SceneType.oResource.ordinal()) {
            ResourceView resource = new ResourceView();
            resource.display();
        }
        

    }

    private void loadHelp() {
        HelpMenuView gameHelp = new HelpMenuView();

        gameHelp.display();
    }

    private void saveGame() {
        SaveGameView saving = new SaveGameView();
        saving.display();
    }

    

}

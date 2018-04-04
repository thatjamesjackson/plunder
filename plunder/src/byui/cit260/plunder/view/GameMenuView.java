/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.Actor;
import byui.cit260.plunder.model.Map;
import byui.cit260.plunder.model.SceneType;
import java.awt.Point;
import plunder.Plunder;
import exceptions.MapControlExeption;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    travel(actor, map, (int) actor.getCoordinates().getY() + 1, (int) actor.getCoordinates().getX());
                } catch (MapControlExeption ex) {
                    Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            break;

            case "W": {
                try {
                    travel(actor, map, (int) actor.getCoordinates().getY(), (int) actor.getCoordinates().getX() - 1);
                } catch (MapControlExeption ex) {
                    Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            break;

            case "E": {
                try {
                    travel(actor, map, (int) actor.getCoordinates().getY(), (int) actor.getCoordinates().getX() + 1);
                } catch (MapControlExeption ex) {
                    Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            break;

            case "S": {
                try {
                    travel(actor, map, (int) actor.getCoordinates().getY() - 1, (int) actor.getCoordinates().getX());
                } catch (MapControlExeption ex) {
                    Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
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
        CrewView crewView = new CrewView();
        crewView.display();
    }

    private void checkShip() {
        System.out.println("Our ship looks yar");
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

        }

        if (type == SceneType.oRough.ordinal()) {

        }

        if (type == SceneType.oCalm.ordinal()) {
            CalmOceanView calm = new CalmOceanView();
            calm.display();
        }
        if (type == SceneType.usOcean.ordinal()) {

        }
        if (type == SceneType.oResource.ordinal()) {

        }
        if (type == SceneType.usLand.ordinal()) {

        }

    }

    private void loadHelp() {
        HelpMenuView gameHelp = new HelpMenuView();

        gameHelp.display();
    }

    private void saveGame() {

    }

    private void travel(Actor actor, Map map, int y, int x) throws MapControlExeption {

        if (y < 0 || y > map.getRowCount() || x < 0 || x > map.getColumnCount()) {
            throw new MapControlExeption("You cannot go that way");
        }
        actor.setCoordinates(new Point(x, y));

    }

}

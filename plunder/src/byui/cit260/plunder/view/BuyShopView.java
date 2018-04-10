/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

import byui.cit260.plunder.model.Game;
import byui.cit260.plunder.model.Ship;
import plunder.Plunder;

/**
 *
 * @author James
 */
public class BuyShopView extends View {

    @Override
    public String[] getInputs() {
        Game game = Plunder.getCurrentGame();
        Ship ship = game.getPlayer().getShip();

        // display menu
        System.out.println("What do ya have the coin for?");

        String format = "%-3s %-30.30s %-10s %n";
        System.out.format(format, "#", "Upgrade", "Cost");
        System.out.println("=========================================");
        //costs are based off current stat
        System.out.format(format, "1", "More Cannons", ship.getShipAttack() * 10);
        System.out.format(format, "2", "Reinforce Hull", ship.getArmor()* 50);
        System.out.format(format, "3", "Thicker Hull", ship.getShipMaxHealth()* 20);
        System.out.format(format, "4", "Larger Cargo Hold", ship.getCarryWeight()* 5);
        System.out.format(format, "5", "Improved Carpentry Shop", ship.getShipRepair()* 10);
        System.out.println("\nYe have " + game.getMoney() + " gold");
        System.out.println("\nQ - Quit to shop");
        //declare new
        String[] inputs = new String[1];

        // retrieve input from user
        String input = this.getInput("Select a menu item");
        inputs[0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
            double cost = 0;
            Game game = Plunder.getCurrentGame();
            Ship ship = Plunder.getCurrentGame().getPlayer().getShip();
        switch (inputs[0]) {
            case "1":
                cost = ship.getShipAttack()* 10;
                if(cost > game.getMoney()){
                    System.out.println("Ye lack enough gold");
                    
                }
                else{
                    game.setMoney(game.getMoney() - cost);
                    ship.setShipAttack(ship.getShipAttack() + 25);
                }
                break;
            case "2":
                cost = ship.getArmor()* 50;
                if(cost > game.getMoney()){
                    ErrorView.display(this.getClass().getName(), "Ye lack enough gold.");
                    
                }
                else{
                    game.setMoney(game.getMoney() - cost);
                    ship.setArmor(ship.getArmor() + 5);
                }
                break;
            case "3":
                cost = ship.getShipMaxHealth()* 20;
                if(cost > game.getMoney()){
                    ErrorView.display(this.getClass().getName(), "Ye lack enough gold.");
                    
                }
                else{
                    game.setMoney(game.getMoney() - cost);
                    ship.setShipMaxHealth(ship.getShipMaxHealth() + 25);
                }
                break;
            case "4":
                cost = ship.getCarryWeight()* 5;
                if(cost > game.getMoney()){
                    ErrorView.display(this.getClass().getName(), "Ye lack enough gold.");
                    
                }
                else{
                    game.setMoney(game.getMoney() - cost);
                    ship.setCarryWeight(ship.getCarryWeight() + 25);
                }
                break;
            case "5":
                cost = ship.getShipRepair()* 10;
                if(cost > game.getMoney()){
                    ErrorView.display(this.getClass().getName(), "Ye lack enough gold.");
                    
                }
                else{
                    game.setMoney(game.getMoney() - cost);
                    ship.setShipRepair(ship.getShipRepair() + 25);
                }
                break;
            case "Q":
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid option");
                

        }

        return false;
    }

}

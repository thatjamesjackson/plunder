/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

/**
 *
 * @author James
 */
public enum Actor {
    Captain("Bob", "a salty capatin", new Point(1,1), 100)
   
    private String name;
    private String description;
    private Point coordinates;
    private double money;
 private Actor(String name, String description, Point coordinates, double money) {
    this.name = name;
    this.description = description;
    this.coordinates = coordinates;
    this.money = money;
    }

}

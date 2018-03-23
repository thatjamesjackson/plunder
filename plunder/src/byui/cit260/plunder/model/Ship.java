/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author James
 */
public class Ship implements Serializable {
    
    private String name;
    private double shipAttack;
    private double carryWeight;
    private double armor;
    private double shipRepair;
    private double shipHealth;
    private double shipMaxHealth;
    private ArrayList <InventoryItem> inventory;

    public Ship() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getShipAttack() {
        return shipAttack;
    }

    public void setShipAttack(double shipAttack) {
        this.shipAttack = shipAttack;
    }

    public double getCarryWeight() {
        return carryWeight;
    }

    public void setCarryWeight(double carryWeight) {
        this.carryWeight = carryWeight;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getShipRepair() {
        return shipRepair;
    }

    public void setShipRepair(double shipRepair) {
        this.shipRepair = shipRepair;
    }
    
    public double getShipMaxHealth() {
        return shipMaxHealth;
    }
    
    public void setShipMaxHealth(double shipMaxHealth) {
        this.shipMaxHealth = shipMaxHealth;
    }

    public double getShipHealth() {
        return shipHealth;
    }

    public void setShipHealth(double shipHealth) {
        this.shipHealth = shipHealth;
    }
    
    public ArrayList getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Ship{" + "name=" + name + ", shipAttack=" + shipAttack + ", carryWeight=" + carryWeight + ", armor=" + armor + ", shipRepair=" + shipRepair + ", shipHealth=" + shipHealth + ", shipMaxHealth=" + shipMaxHealth + ", inventory=" + inventory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.shipAttack) ^ (Double.doubleToLongBits(this.shipAttack) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.carryWeight) ^ (Double.doubleToLongBits(this.carryWeight) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.armor) ^ (Double.doubleToLongBits(this.armor) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.shipRepair) ^ (Double.doubleToLongBits(this.shipRepair) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.shipHealth) ^ (Double.doubleToLongBits(this.shipHealth) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.shipMaxHealth) ^ (Double.doubleToLongBits(this.shipMaxHealth) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.inventory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ship other = (Ship) obj;
        if (Double.doubleToLongBits(this.shipAttack) != Double.doubleToLongBits(other.shipAttack)) {
            return false;
        }
        if (Double.doubleToLongBits(this.carryWeight) != Double.doubleToLongBits(other.carryWeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.armor) != Double.doubleToLongBits(other.armor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.shipRepair) != Double.doubleToLongBits(other.shipRepair)) {
            return false;
        }
        if (Double.doubleToLongBits(this.shipHealth) != Double.doubleToLongBits(other.shipHealth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.shipMaxHealth) != Double.doubleToLongBits(other.shipMaxHealth)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        return true;
    }
    
    
}

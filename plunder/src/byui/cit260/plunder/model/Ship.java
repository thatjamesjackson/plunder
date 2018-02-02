/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author James
 */
public class Ship implements Serializable {

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.shipAttack) ^ (Double.doubleToLongBits(this.shipAttack) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.carryWeight) ^ (Double.doubleToLongBits(this.carryWeight) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.armor) ^ (Double.doubleToLongBits(this.armor) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.shipRepair) ^ (Double.doubleToLongBits(this.shipRepair) >>> 32));
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" + "name=" + name + ", shipAttack=" + shipAttack + ", carryWeight=" + carryWeight + ", armor=" + armor + ", shipRepair=" + shipRepair + '}';
    }
    private String name;
    private double shipAttack;
    private double carryWeight;
    private double armor;
    private double shipRepair;

    public Ship(String name, double shipAttack, double carryWeight, double armor, double shipRepair) {
        this.name = name;
        this.shipAttack = shipAttack;
        this.carryWeight = carryWeight;
        this.armor = armor;
        this.shipRepair = shipRepair;
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
    
    
}

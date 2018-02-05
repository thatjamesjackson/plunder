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
public class Upgrade implements Serializable {

    @Override
    public String toString() {
        return "Upgrade{" + "type=" + type + ", cost=" + cost + ", statBoost=" + statBoost + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getStatBoost() {
        return statBoost;
    }

    public void setStatBoost(double statBoost) {
        this.statBoost = statBoost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.statBoost) ^ (Double.doubleToLongBits(this.statBoost) >>> 32));
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
        final Upgrade other = (Upgrade) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (Double.doubleToLongBits(this.statBoost) != Double.doubleToLongBits(other.statBoost)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    public Upgrade() {
    }
    private String type;
    private double cost;
    private double statBoost;
}

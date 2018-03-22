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
public class Trap extends DecisionScene{
    private double lostHealth;

    public Trap() {
    }
    
    public double getLostHealth() {
        return lostHealth;
    }

    public void setLostHealth(double lostHealth) {
        this.lostHealth = lostHealth;
    }
    
    @Override
    public String toString() {
        return "Trap{" + "lostHealth=" + lostHealth + super.toString() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.lostHealth) ^ (Double.doubleToLongBits(this.lostHealth) >>> 32));
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
        final Trap other = (Trap) obj;
        if (Double.doubleToLongBits(this.lostHealth) != Double.doubleToLongBits(other.lostHealth)) {
            return false;
        }
        return true;
    }
}

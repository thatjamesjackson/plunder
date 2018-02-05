/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import java.util.Objects;

/**
 *
 * @author James
 */
public class DecisionScene extends RegularScene{

    @Override
    public String toString() {
        return "DecisionScene{" + "ask=" + ask + ", consequnce=" + consequnce + super.toString() + '}';
    }
    private String ask;
    private Decision consequnce;

    public DecisionScene() {
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public Decision getConsequnce() {
        return consequnce;
    }

    public void setConsequnce(Decision consequnce) {
        this.consequnce = consequnce;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.ask);
        hash = 37 * hash + Objects.hashCode(this.consequnce);
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
        final DecisionScene other = (DecisionScene) obj;
        if (!Objects.equals(this.ask, other.ask)) {
            return false;
        }
        if (!Objects.equals(this.consequnce, other.consequnce)) {
            return false;
        }
        return true;
    }
    
    
}

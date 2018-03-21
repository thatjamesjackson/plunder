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
    
    private String Ask;
    private String Options;

    public DecisionScene() {
    }

    public String getAsk() {
        return Ask;
    }

    public void setAsk(String Ask) {
        this.Ask = Ask;
    }

    public String getOptions() {
        return Options;
    }

    public void setOptions(String Options) {
        this.Options = Options;
    }

    @Override
    public String toString() {
        return "DecisionScene{" + "Ask=" + Ask + ", Options=" + Options + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.Ask);
        hash = 13 * hash + Objects.hashCode(this.Options);
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
        if (!Objects.equals(this.Ask, other.Ask)) {
            return false;
        }
        if (!Objects.equals(this.Options, other.Options)) {
            return false;
        }
        return true;
    }

}

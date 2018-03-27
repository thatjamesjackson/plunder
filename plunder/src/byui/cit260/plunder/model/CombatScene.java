/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import byui.cit260.plunder.view.View;
import java.util.Objects;

/**
 *
 * @author James
 */
public class CombatScene extends DecisionScene {

    private Ship opponent;
    
    public CombatScene() {
        
    }

    public CombatScene(Ship opponent) {
        this.opponent = opponent;
    }

    public CombatScene(Ship opponent, String description, String mapSymbol, View nextView) {
        super(description, mapSymbol, nextView);
        this.opponent = opponent;
    }
    
    public Ship getOpponent() {
        return opponent;
    }

    public void setOpponent(Ship opponent) {
        this.opponent = opponent;
    }
    
    @Override
    public String toString() {
        return "CombatScene{" + "opponent=" + opponent + super.toString() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.opponent);
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
        final CombatScene other = (CombatScene) obj;
        if (!Objects.equals(this.opponent, other.opponent)) {
            return false;
        }
        return true;
    }
}

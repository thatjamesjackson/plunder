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
public class ShopScene extends RegularScene{
    private Upgrade upgrade; 

    public ShopScene() {
    }
    
    public Upgrade getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Upgrade upgrade) {
        this.upgrade = upgrade;
    }
    
    @Override
    public String toString() {
        return "ShopScene{" + "upgrade=" + upgrade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.upgrade);
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
        final ShopScene other = (ShopScene) obj;
        if (!Objects.equals(this.upgrade, other.upgrade)) {
            return false;
        }
        return true;
    }
}

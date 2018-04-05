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
public class ResourceScene extends RegularScene{
    private InventoryItem resource;

    public ResourceScene() {
    }
    
    public ResourceScene( String description, String mapSymbol, int sceneType,  ) {
        super(description, mapSymbol, sceneType);
        
    }
    
    public InventoryItem getResource() {
        return resource;
    }

    public void setResource(InventoryItem resource) {
        this.resource = resource;
    }
    
    @Override
    public String toString() {
        return "ResourceScene{" + "resource=" + resource + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.resource);
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
        final ResourceScene other = (ResourceScene) obj;
        if (!Objects.equals(this.resource, other.resource)) {
            return false;
        }
        return true;
    }

}

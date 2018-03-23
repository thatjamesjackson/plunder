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
public class Decision implements Serializable{

    private String result;

    public Decision() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    @Override
    public String toString() {
        return "Decision{" + "result=" + result + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.result);
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
        final Decision other = (Decision) obj;
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        return true;
    }
    
}

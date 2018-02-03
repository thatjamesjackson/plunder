/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import java.util.Objects;

/**
 *
 * @author abigailking
 */
public class Question {
    private boolean isAsked;
    private String askNPC;
    private String npcResponse;

    public boolean isIsAsked() {
        return isAsked;
    }

    public void setIsAsked(boolean isAsked) {
        this.isAsked = isAsked;
    }

    public String getAskNPC() {
        return askNPC;
    }

    public void setAskNPC(String askNPC) {
        this.askNPC = askNPC;
    }

    public String getNpcResponse() {
        return npcResponse;
    }

    public void setNpcResponse(String npcResponse) {
        this.npcResponse = npcResponse;
    }

    public Question(boolean isAsked, String askNPC, String npcResponse) {
        this.isAsked = isAsked;
        this.askNPC = askNPC;
        this.npcResponse = npcResponse;
    }

    @Override
    public String toString() {
        return "Question{" + "isAsked=" + isAsked + ", askNPC=" + askNPC + ", npcResponse=" + npcResponse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.isAsked ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.askNPC);
        hash = 53 * hash + Objects.hashCode(this.npcResponse);
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
        final Question other = (Question) obj;
        if (this.isAsked != other.isAsked) {
            return false;
        }
        if (!Objects.equals(this.askNPC, other.askNPC)) {
            return false;
        }
        if (!Objects.equals(this.npcResponse, other.npcResponse)) {
            return false;
        }
        return true;
    }
    
}

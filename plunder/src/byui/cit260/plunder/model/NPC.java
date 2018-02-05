/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

/**
 *
 * @author abigailking
 */
public class NPC {

    private boolean isCrew;
    private int crewAttack;
    private int crewRepair;
    private Question[] questions;
    
    public NPC() {
    }

    public boolean isIsCrew() {
        return isCrew;
    }

    public void setIsCrew(boolean isCrew) {
        this.isCrew = isCrew;
    }

    public int getCrewAttack() {
        return crewAttack;
    }

    public void setCrewAttack(int crewAttack) {
        this.crewAttack = crewAttack;
    }

    public int getCrewRepair() {
        return crewRepair;
    }

    public void setCrewRepair(int crewRepair) {
        this.crewRepair = crewRepair;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "NPC{" + "isCrew=" + isCrew + ", crewAttack=" + crewAttack + ", crewRepair=" + crewRepair + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.isCrew ? 1 : 0);
        hash = 59 * hash + this.crewAttack;
        hash = 59 * hash + this.crewRepair;
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
        final NPC other = (NPC) obj;
        if (this.isCrew != other.isCrew) {
            return false;
        }
        if (this.crewAttack != other.crewAttack) {
            return false;
        }
        if (this.crewRepair != other.crewRepair) {
            return false;
        }
        return true;
    }
    
}

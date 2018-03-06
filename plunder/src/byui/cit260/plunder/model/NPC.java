/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author abigailking
 */
public class NPC {

    private boolean isCrew;
    private int crewAttack;
    private int crewRepair;
    private String job;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    private Question[] questions;
    
    public NPC() {
    }

    public boolean getIsCrew() {
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
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.isCrew ? 1 : 0);
        hash = 97 * hash + this.crewAttack;
        hash = 97 * hash + this.crewRepair;
        hash = 97 * hash + Objects.hashCode(this.job);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Arrays.deepHashCode(this.questions);
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
        if (!Objects.equals(this.job, other.job)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Arrays.deepEquals(this.questions, other.questions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NPC{" + "isCrew=" + isCrew + ", crewAttack=" + crewAttack + ", crewRepair=" + crewRepair + ", job=" + job + ", name=" + name + ", questions=" + questions + '}';
    }

    

    
    
    
}

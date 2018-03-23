/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;
import java.io.Serializable;
import java.util.ArrayList;
import byui.cit260.plunder.model.InventoryItem;
/**
 *
 * @author James
 */
public class Game implements Serializable{
    
    private double totalTime;
    private double progress;
    private Player player;
    private double money;
    private Map map;
    private ArrayList <InventoryItem> inventory = new ArrayList <InventoryItem>();
    private NPC[] npc;
    
    public Game() {
        
    }
    
    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
    
    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public ArrayList<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public NPC[] getNpc() {
        return npc;
    }

    public void setNpc(NPC[] npc) {
        this.npc = npc;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", progress=" + progress + ", player=" + player + ", money=" + money + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.progress) ^ (Double.doubleToLongBits(this.progress) >>> 32));
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.progress) != Double.doubleToLongBits(other.progress)) {
            return false;
        }
        return true;
    }
    
}

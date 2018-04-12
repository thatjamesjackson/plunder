/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import java.io.Serializable;
import java.util.ArrayList;
import byui.cit260.plunder.model.InventoryItem;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author James
 */
public class Game implements Serializable {

    private boolean endGame;
    private double progress;
    private Player player;
    private double money;
    private Map map;
    private NPC[] npc;

    public Game() {
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
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

    public NPC[] getNPC() {
        return npc;
    }

    public void setNPC(NPC[] npc) {
        this.npc = npc;
    }

    @Override
    public String toString() {
        return "Game{" + "endGame=" + endGame + ", progress=" + progress + ", player=" + player + ", money=" + money + ", map=" + map + ", npc=" + npc + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.endGame ? 1 : 0);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.progress) ^ (Double.doubleToLongBits(this.progress) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.player);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.money) ^ (Double.doubleToLongBits(this.money) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.map);
        hash = 19 * hash + Arrays.deepHashCode(this.npc);
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
        if (this.endGame != other.endGame) {
            return false;
        }
        if (Double.doubleToLongBits(this.progress) != Double.doubleToLongBits(other.progress)) {
            return false;
        }
        if (Double.doubleToLongBits(this.money) != Double.doubleToLongBits(other.money)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Arrays.deepEquals(this.npc, other.npc)) {
            return false;
        }
        return true;
    }

}

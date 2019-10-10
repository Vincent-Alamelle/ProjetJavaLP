package object.item;

import constante.ConstanteInt;
import init.Init;

import java.util.ArrayList;
import java.util.Arrays;

public class Item {
    private String name;
    private int rank, level;
    private int attackBoost = 0, healthBoost = 0, defenseBoost = 0, speedBoost = 0, critBoost = 0;

    public Item(String name, int rank, int attackBoost, int healthBoost, int defenseBoost, int speedBoost) {
        this.name = name;
        this.rank = rank;
        this.attackBoost = attackBoost;
        this.healthBoost = healthBoost;
        this.defenseBoost = defenseBoost;
        this.speedBoost = speedBoost;
        this.level = 0;
    }

    public Item(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.level = 0;
    }

    public void lvlup(){
        Init.player.substractGold(ConstanteInt.ITEM_PRICE_UP.getValeur() * (this.getLevel()+1));
        if (this.getAttackBoost() != 0)
            this.setAttackBoost(this.getAttackBoost()+ ConstanteInt.ITEM_ATTACK_UP.getValeur()*this.getRank());
        if (this.getHealthBoost() != 0)
            this.setHealthBoost(this.getHealthBoost()+ ConstanteInt.ITEM_HEALTH_UP.getValeur()*this.getRank());
        if (this.getDefenseBoost() != 0)
            this.setDefenseBoost(this.getDefenseBoost()+ ConstanteInt.ITEM_DEFENSE_UP.getValeur()*this.getRank());
        if (this.getSpeedBoost() != 0)
            this.setSpeedBoost(this.getSpeedBoost()+ ConstanteInt.ITEM_SPEED_UP.getValeur());
        if (this.getCritBoost() != 0)
            this.setCritBoost(this.getCritBoost()+ ConstanteInt.ITEM_CRIT_UP.getValeur());
        this.setLevel(this.getLevel()+1);
    }

    public void setStat(){
        ArrayList<String> stats = new ArrayList<>(Arrays.asList("attack","health","defense","speed","crit"));
        double rand;
        int count = this.getRank();
        while (count > 0){
            rand = Math.random() * stats.size();
            stats.remove((int) rand);
            --count;
        }
        if (!stats.contains("attack"))
            this.setAttackBoost(20 + 10 * this.getRank());
        if (!stats.contains("health"))
            this.setHealthBoost(50 + 20 * this.getRank());
        if (!stats.contains("defense"))
            this.setDefenseBoost(10 + 5 * this.getRank());
        if (!stats.contains("speed"))
            this.setSpeedBoost(5 + this.getRank());
        if (!stats.contains("crit"))
            this.setCritBoost(7 + 2 * this.getRank());
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCritBoost() {
        return critBoost;
    }

    public void setCritBoost(int critBoost) {
        this.critBoost = critBoost;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public int getSpeedBoost() {
        return speedBoost;
    }

    public void setSpeedBoost(int speedBoost) {
        this.speedBoost = speedBoost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                "{ rank=" + rank +
                ", attackBoost=" + attackBoost +
                ", healthBoost=" + healthBoost +
                ", defenseBoost=" + defenseBoost +
                ", speedBoost=" + speedBoost +
                ", critBoost=" + critBoost +
                '}';
    }
}

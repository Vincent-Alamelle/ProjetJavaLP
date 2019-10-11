package object.player;

import constante.ConstanteDouble;
import constante.ConstanteInt;
import object.item.Item;
import object.monster.Monster;
import object.plot.Plot;
import object.utils.Utils;

import java.util.ArrayList;

public class Player {
    private int gold, nbFragmentStone;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Plot> plots = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

    public void summon(){
        substractFragmentStone(ConstanteInt.SUMMON_COST.getValeur());
        Utils.obtenir("monster");
        this.getMonsters().get(this.getMonsters().size()-1).setPlayer();
        System.out.println("Félécitations vous venez d'invoquer : " + this.getMonsters().get(this.getMonsters().size()-1));
    }

    public void showMonsters(){
        for (int i = 0; i < this.getMonsters().size(); ++i) {
            System.out.println(this.getMonsters().get(i));
        }
    }

    public void showItems(){
        for (int i = 0; i < this.getItems().size(); ++i) {
            System.out.println(i+1 + ". " + this.getItems().get(i));
        }
    }

    public void regenMonsters() {
        System.out.println(this.getMonsters() + "\n");
        for (int i = 0; i < this.getMonsters().size() -1; i++) {
            this.getMonsters().get(i).setCurrentHealth(this.getMonsters().get(i).getHealthMax());
        }
        System.out.println(this.getMonsters());
    }

    public void addFragmentStone(int amount){
        this.setNbFragmentStone(this.getNbFragmentStone()+amount);
    }

    public void substractFragmentStone(int amount){
        this.setNbFragmentStone(this.getNbFragmentStone()-amount);
    }

    public void addGold(int amount){
        this.setGold(this.getGold()+amount);
    }

    public void substractGold(int amount){
        this.setGold(this.getGold()-amount);
    }

    public void addMonster(Monster monster){
        this.getMonsters().add(monster);
    }

    public void removeMonster(Monster monster){
        this.getMonsters().remove(monster);
    }

    public void addPlot(Plot plot){
        this.getPlots().add(plot);
    }

    public void addItem(Item item){
        this.getItems().add(item);
    }

    public void removeItem(Item item){
        this.getItems().remove(item);
    }

    public int getNbFragmentStone() {
        return nbFragmentStone;
    }

    private void setNbFragmentStone(int nbFragmentStone) {
        this.nbFragmentStone = nbFragmentStone;
    }

    public int getGold() {
        return gold;
    }

    private void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Plot> getPlots() {
        return plots;
    }

    public void setPlots(ArrayList<Plot> plots) {
        this.plots = plots;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

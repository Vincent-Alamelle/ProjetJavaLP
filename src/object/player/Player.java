package object.player;

import constante.ConstanteInt;
import object.item.Item;
import object.monster.Monster;
import object.utils.Utils;

import java.util.ArrayList;

public class Player {
    private static Player player = null;
    private int gold, nbFragmentStone;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private boolean hasBegin = true;

    private Player() {
        this.gold = 0;
        this.nbFragmentStone = 0;
    }

    public static Player getInstance(){
        if (player == null) player = new Player();
        return player;
    }

    public void summon(){
        this.setHasBegin();
        this.substractFragmentStone(ConstanteInt.SUMMON_COST.getValeur());
        Utils.get("monster");
        this.getMonsters().get(this.getMonsters().size()-1).setPlayer();
        System.out.println("Félécitations vous venez d'invoquer : " + this.getMonsters().get(this.getMonsters().size()-1));
    }

    public void showMonsters(){
        for (int i = 0; i < this.getMonsters().size(); ++i) {
            System.out.println(i + ". " + this.getMonsters().get(i));
        }
    }

    public void showItems(){
        for (int i = 0; i < this.getItems().size(); ++i) {
            System.out.println(i + ". " + this.getItems().get(i));
        }
    }

    public void regenMonsters() {
        for (int i = 0; i < this.getMonsters().size(); i++) {
            this.getMonsters().get(i).setCurrentHealth(this.getMonsters().get(i).getHealthMax());
        }
    }

    public boolean isHasBegin() {
        return hasBegin;
    }

    private void setHasBegin() {
        this.hasBegin = false;
    }

    public void addFragmentStone(int amount){
        this.setNbFragmentStone(this.getNbFragmentStone()+amount);
    }

    private void substractFragmentStone(int amount){
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

    public ArrayList<Item> getItems() {
        return items;
    }
}

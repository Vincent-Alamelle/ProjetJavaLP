package object.monster;

import constante.ConstanteInt;
import init.Init;
import object.item.Item;
import object.player.Player;

import java.util.ArrayList;

public abstract class Monster {
    private String name,type;
    private int healthMax, currentHealth, attack, defense, speed, turnBar, level, experience, rank;
    private double crit;
    private boolean isPlayer = false;
    private String element;
    private ArrayList<Item> items;

    public Monster(String name, String type, int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        this.name = name;
        this.type = type;
        this.currentHealth = healthMax;
        this.attack = attack;
        this.crit = 0.20;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.experience = experience;
        this.rank = rank;
        this.turnBar = 0;
        this.element = element;
        this.healthMax = healthMax;
        this.items = new ArrayList<>(6);
    }

    public void attack(Monster monster){

        switch (this.getElement()){
            case "vent":
                makeAttack("eau","terre",monster);
                break;
            case "eau":
                makeAttack("feu","vent",monster);
                break;
            case "feu":
                makeAttack("terre","eau",monster);
                break;
            case "terre":
                makeAttack("vent","feu",monster);
                break;
        }
    }

    private void makeAttack(String strongElement, String weakElement, Monster monster){
        double rand = (Math.random());
        if (monster.getElement().equals(strongElement)){
            if (!(((int) (this.getAttack()*1.25)) < monster.getDefense())) {
                if (Double.compare(rand, this.getCrit()) < 0)
                    monster.setCurrentHealth((int) (monster.getCurrentHealth() - (this.getAttack() * 1.5 * 1.25 - monster.getDefense())));
                else
                    monster.setCurrentHealth((int) (monster.getCurrentHealth() - (this.getAttack() * 1.25 - monster.getDefense())));
            }
        }
        else if(monster.getElement().equals(weakElement)){
            if (!(((int) (this.getAttack()*0.75)) < monster.getDefense())){
                if (Double.compare(rand, this.getCrit()) < 0)
                    monster.setCurrentHealth((int) (monster.getCurrentHealth()-(this.getAttack()*1.5*0.75-monster.getDefense())));
                else
                    monster.setCurrentHealth((int) (monster.getCurrentHealth()-(this.getAttack()*0.75-monster.getDefense())));
            }
        }
        else{
            if (!(this.getAttack() < monster.getDefense())){
                if (Double.compare(rand, this.getCrit()) < 0)
                    monster.setCurrentHealth((int) (monster.getCurrentHealth()-(this.getAttack()*1.5-monster.getDefense())));
                else
                    monster.setCurrentHealth(monster.getCurrentHealth()-(this.getAttack()-monster.getDefense()));
            }
        }
    }

    public void setStatsByLevelAndRank(){
        setHealthbyLevelAndRank();
        setAttackbyLevelAndRank();
        setDefensebyLevelAndRank();
    }

    private  void setHealthbyLevelAndRank(){
        this.setHealthMax(this.getHealthMax() + (this.getLevel() * ConstanteInt.MONSTER_HEALTH_PER_LVL.getValeur() +
                this.getRank() * ConstanteInt.MONSTER_HEALTH_PER_RANK.getValeur()));
        this.setCurrentHealth(this.getHealthMax());
    }
    private  void setAttackbyLevelAndRank(){
        this.setAttack(this.getAttack() + (this.getLevel() * ConstanteInt.MONSTER_ATTACK_PER_LVL.getValeur() +
                this.getRank() * ConstanteInt.MONSTER_ATTACK_PER_RANK.getValeur()));
    }
    private  void setDefensebyLevelAndRank(){
        this.setDefense(this.getDefense() + (this.getLevel() * ConstanteInt.MONSTER_DEFENSE_PER_LVL.getValeur() +
                this.getRank() * ConstanteInt.MONSTER_DEFENSE_PER_RANK.getValeur()));
    }

    public void addExperience(int amount){
        if (this.getLevel() < ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(this.getRank()-1))){
            int total = this.getExperience()+amount;
            if (total >= (ConstanteInt.MAX_XP_LVL.getValeur()*this.getLevel())){
                this.setExperience(total-(ConstanteInt.MAX_XP_LVL.getValeur()*this.getLevel()));
                lvlUp();
            }
            else
                this.setExperience(total);
        }
    }

    public void equip(Item item){
        Item itemEquip = null;
        boolean isEquip = true;
        if (this.getItems().size() == 0) {
            this.getItems().add(item);
            addItemStats(item);
            Player.getInstance().removeItem(item);
        }
        else {
            for (int i = 0; i < this.getItems().size(); ++i) {
                if (!(this.getItems().get(i).getName().equals(item.getName()))) {
                    isEquip = false;
                } else {
                    itemEquip = this.getItems().get(i);
                    isEquip = true;
                    break;
                }
            }
            if (isEquip){
                Player.getInstance().addItem(itemEquip);
                removeItemStats(itemEquip);
                this.getItems().remove(itemEquip);

                this.getItems().add(item);
                addItemStats(item);
                Player.getInstance().removeItem(item);
            }
            else {
                this.getItems().add(item);
                addItemStats(item);
                Player.getInstance().removeItem(item);
            }
        }
    }

    public void updateItemStats(Item item){
        equip(item);
    }

    private void addItemStats(Item item){
        this.setHealthMax(this.getHealthMax()+item.getHealthBoost());
        this.setCurrentHealth(this.getHealthMax());
        this.setAttack(this.getAttack()+item.getAttackBoost());
        this.setDefense(this.getDefense()+item.getDefenseBoost());
        this.setSpeed(this.getSpeed()+item.getSpeedBoost());
        this.setCrit(this.getCrit()+item.getCritBoost());
    }

    private void removeItemStats(Item item){
        this.setHealthMax(this.getHealthMax()-item.getHealthBoost());
        this.setCurrentHealth(this.getHealthMax());
        this.setAttack(this.getAttack()-item.getAttackBoost());
        this.setDefense(this.getDefense()-item.getDefenseBoost());
        this.setSpeed(this.getSpeed()-item.getSpeedBoost());
        this.setCrit(this.getCrit()-item.getCritBoost());
    }

    public void showItems(){
        for (int i = 0; i < this.getItems().size(); ++i) {
            System.out.println(this.getItems().get(i));
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    private void lvlUp(){
        this.setLevel(this.getLevel()+1);
    }

    public void setLevel(int level) {
        this.level = level;
        setHealthbyLevelAndRank();
        setAttackbyLevelAndRank();
        setDefensebyLevelAndRank();
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getRank() {
        return rank;
    }

    private void setCrit(double crit) {
        this.crit = crit;
    }

    private double getCrit() {
        return crit;
    }

    public String getType() {
        return type;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int health) {
        this.healthMax = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    private int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getTurnBar() {
        return turnBar;
    }

    public void setTurnBar(int turnBar) {
        this.turnBar = turnBar;
    }

    public void setPlayer() {
        isPlayer = true;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    private int getExperience() {
        return experience;
    }

    public String getElement() {
        return element;
    }

    private void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return name +"{" +
                "type='" + type + '\'' +
                ", element=" + element +
                ", healthMax=" + healthMax +
                ", currentHealth=" + currentHealth +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", level=" + level +
                ", experience=" + experience +
                ", rank=" + rank +
                '}';
    }
}
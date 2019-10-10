package object.monster;

import constante.ConstanteInt;

public abstract class Monster {
    private String name,type;
    private int healthMax, currentHealth, attack, defense, speed, turnBar, level, experience, rank;
    private double crit;
    private boolean isPlayer = false;

    public Monster(String name, String type, int healthMax, int attack, int defense, int speed, int level, int experience, int rank) {
        this.name = name;
        this.type = type;
        this.healthMax = healthMax;
        this.currentHealth = healthMax;
        this.attack = attack;
        this.crit = 0.20;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.experience = experience;
        this.rank = rank;
        this.turnBar = 0;
    }

    public Monster(){}

    public void attack(Monster monster){
        double rand = (Math.random());
        if (Double.compare(rand, this.getCrit()) < 0)
            monster.setCurrentHealth((int) (monster.getCurrentHealth()-(this.getAttack()*1.5-monster.getDefense())));
        else
            monster.setCurrentHealth(monster.getCurrentHealth()-(this.getAttack()-monster.getDefense()));
    }

    protected abstract void setHealthbyLevelAndRank();
    protected abstract void setAttackbyLevelAndRank();
    protected abstract void setDefensebyLevelAndRank();

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
        setHealthbyLevelAndRank();
        setAttackbyLevelAndRank();
        setDefensebyLevelAndRank();
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getCrit() {
        return crit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        setHealthbyLevelAndRank();
        setAttackbyLevelAndRank();
        setDefensebyLevelAndRank();
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

    public int getExperience() {
        return experience;
    }

    public void addExperience(int amount){
        if (this.getLevel() < ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(this.getRank()-1))){
            int total = this.getExperience()+amount;
            if (total >= (ConstanteInt.MAX_XP_LVL.getValeur()*this.getLevel())){
                this.setExperience(total-(ConstanteInt.MAX_XP_LVL.getValeur()*this.getLevel()));
            }
            else
                this.setExperience(total);
        }
    }

    private void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return name +"{" +
                "type='" + type + '\'' +
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
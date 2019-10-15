package object.quest;
import constante.ConstanteDouble;
import constante.ConstanteInt;
import init.Init;
import object.chest.Chest;
import object.monster.Monster;
import object.utils.Utils;

import java.util.ArrayList;

public class Quest {
    private String name;
    private int lvl;
    private int xp;
    private int gold;
    private int difficulty;
    private boolean chestFound = false;
    private Chest chest;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Monster> playerMonsters = new ArrayList<>();

    public Quest(String name, int lvl, int difficulty) {
        this.name = name;
        this.lvl = lvl;
        this.difficulty = difficulty;
        setMonsters();
    }

    private ArrayList<Monster> getMonsters() {
        return monsters;
    }

    private void showMonsters(){
        int counter1 = 1;
        int counter2 = 0;
        int counter3 = 0;
        for (int i = 1; i < this.getMonsters().size(); ++i) {
            if (this.getMonsters().get(0).getName().equals(this.getMonsters().get(i).getName()))
                ++counter1;
            else{
                if(i != 1){
                    if (this.getMonsters().get(1).getName().equals(this.getMonsters().get(i).getName())) {
                        ++counter2;
                    }
                    else
                        ++counter3;
                }
                else
                    ++counter2;
            }
        }
        if (counter1 == this.getMonsters().size())
            System.out.println("Vous avez rencontré : " + counter1 + "x " + this.getMonsters().get(0).getType());
        else if(counter1 == this.getMonsters().size()-1 && counter3 == 0)
            System.out.println("Vous avez rencontré : x" + counter1 + this.getMonsters().get(0).getType() + ", x" +
                    counter2 + this.getMonsters().get(0).getType() + ".");
        else
            System.out.println("Vous avez rencontré : x" + counter1 + this.getMonsters().get(0).getType() + ", x" +
                counter2 + this.getMonsters().get(0).getType() + ", x" + counter3 + this.getMonsters().get(0).getType() + ".");
    }


    private void setMonsters() {
        int counter = 3;
        while (counter != 0){
            this.getMonsters().add(Utils.getMonsterRandomly(Utils.getMonsterByRank(this.getLvl())));
            --counter;
        }
        for (int i = 0; i < this.getMonsters().size(); i++) {
            setStats(this.getMonsters().get(i));
        }
    }

    private void setStats(Monster monster){
        switch (this.getDifficulty()){
            case 1 :
                setStatsByDifficulty("easy",monster);
                break;
            case 2 :
                monster.setLevel((ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(monster.getRank())-1))/2);
                setStatsByDifficulty("easy",monster);
                break;
            case 3 :
                monster.setLevel(ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(monster.getRank())-1));
                setStatsByDifficulty("easy",monster);
                break;
            case 4 :
                setStatsByDifficulty("normal",monster);
                break;
            case 5 :
                monster.setLevel((ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(monster.getRank())-1))/2);
                setStatsByDifficulty("normal",monster);
                break;
            case 6 :
                monster.setLevel((ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(monster.getRank())-1)));
                setStatsByDifficulty("normal",monster);
                break;
            case 7 :
                setStatsByDifficulty("hard",monster);
                break;
            case 8 :
                monster.setLevel((ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(monster.getRank())-1))/2);
                setStatsByDifficulty("hard",monster);
                break;
            case 9 :
                monster.setLevel((ConstanteInt.MAX_LVL_RANK1.getValeur() + (5*(monster.getRank())-1)));
                setStatsByDifficulty("hard",monster);
                break;
            default: break;
        }
    }

    private void setStatsByDifficulty(String difficulty, Monster monster){
        switch (difficulty){
            case "easy":
                monster.setAttack((int) ((monster.getAttack()) * ConstanteDouble.MOBS_WEAK.getValeur()));
                monster.setHealthMax((int) ((monster.getHealthMax()) * ConstanteDouble.MOBS_WEAK.getValeur()));
                monster.setDefense((int) ((monster.getDefense()) * ConstanteDouble.MOBS_WEAK.getValeur()));
                break;
            case "normal":
                monster.setAttack((int) ((monster.getAttack()) * ConstanteDouble.MOBS_NORMAL.getValeur()));
                monster.setHealthMax((int) ((monster.getHealthMax()) * ConstanteDouble.MOBS_NORMAL.getValeur()));
                monster.setDefense((int) ((monster.getDefense()) * ConstanteDouble.MOBS_NORMAL.getValeur()));
                break;
            case "hard":
                monster.setAttack((int) ((monster.getAttack()) * ConstanteDouble.MOBS_HARD.getValeur()));
                monster.setHealthMax((int) ((monster.getHealthMax()) * ConstanteDouble.MOBS_HARD.getValeur()));
                monster.setDefense((int) ((monster.getDefense()) * ConstanteDouble.MOBS_HARD.getValeur()));
                break;
            default:
                break;
        }
    }

    private int getDifficulty() {
        return difficulty;
    }

    private int getLvl() {
        return lvl;
    }

    private int getXp() {
        return xp;
    }

    private void setXp(int xp) {
        this.xp = xp;
    }

    private int getGold() {
        return gold;
    }

    private void setGold(int gold) {
        this.gold = gold;
    }

    private Chest getChest() {
        return chest;
    }

    private void setChest(Chest chest) {
        this.chest = chest;
    }

    private boolean isChestFound() {
        return chestFound;
    }

    private void setChestFound(boolean chestFound) {
        this.chestFound = chestFound;
    }

    public void setPlayerMonsters(ArrayList<Monster> monsters){
        this.playerMonsters = monsters;
    }

    private ArrayList<Monster> getPlayerMonsters() {
        return playerMonsters;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", lvl=" + lvl +
                ", xp=" + xp +
                ", gold=" + gold +
                '}';
    }

    private void isChest() {
        double randChest = 1 + (Math.random() * (100 - 1));

        if (Double.compare(randChest, 11*getLvl()) < 0) {
            double randChestTemp = 1 + (Math.random() * (5 - 1));
            int randChestRank = (int) randChestTemp;
            this.setChest(new Chest(randChestRank));
            setChestFound(true);
        }
        else {
            setChestFound(false);
        }
    }

    private void reward(int lvl) {
        setGold(lvl + 10);
        setXp(lvl * 10);
    }

    private void giveReward(){
        if (this.isChestFound()){
            this.setGold(this.getGold() + this.getChest().getGold());
            Init.player.addFragmentStone(this.getChest().getInvocationShard());
            Init.player.addItem(this.getChest().getItem());
        }
        Init.player.addGold(this.getGold());
        for (int i = 0; i < this.getPlayerMonsters().size(); ++i) {
            this.getPlayerMonsters().get(i).addExperience(this.getXp());
        }
    }

    public void goOnQuest() {
        reward(getLvl());
        isChest();
        showMonsters();
        if(Utils.fight(this.getPlayerMonsters(),this.getMonsters()))
            questComplete();
        else
            System.out.println("Vous avez échoué votre quête :/");
        Init.player.regenMonsters();
    }

    private void questComplete() {

        String rewardString = "Tu as gagné " + this.getXp() + " points d'xp\nAinsi que " + this.getGold() + " pièces d'or";
        if (isChestFound()) {
            rewardString = rewardString + "\nWow tu as été craiment chanceux; tu as obtenu un coffre de rang " + this.getChest().getRank();
        }
        giveReward();
        System.out.println(rewardString);
    }


}

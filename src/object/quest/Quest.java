package object.quest;
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
    boolean chestFound = false;
    private Chest chest;
    private String rewardString;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Monster> playerMonsters = new ArrayList<>();

    public Quest(String name, int lvl) {
        this.name = name;
        this.lvl = lvl;
        setMonsters();
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void showMonsters(){
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


    public void setMonsters() {
        int counter = 3;
        while (counter != 0){
            this.getMonsters().add(Utils.getMonsterRandomly(Utils.getMonsterByRank(this.getLvl())));
            --counter;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public boolean isChestFound() {
        return chestFound;
    }

    public void setChestFound(boolean chestFound) {
        this.chestFound = chestFound;
    }

    public void setPlayerMonsters(ArrayList<Monster> monsters){
        this.playerMonsters = monsters;
    }

    public ArrayList<Monster> getPlayerMonsters() {
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
        Init.player.addGold(this.getGold());
        for (int i = 0; i < Init.player.getMonsters().size(); ++i) {
            Init.player.getMonsters().get(i).addExperience(this.getXp());
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
    }

    private void questComplete() {

        rewardString = "Tu as gagné " + this.getXp() + " points d'xp\nAinsi que " + this.getGold() + " pièces d'or";
        if (isChestFound()) {
            rewardString = rewardString + "\nWow tu as été craiment chanceux; tu as obtenu un coffre de rang " + this.getChest().getRank();
        }
        giveReward();
        System.out.println(rewardString);
        Init.player.regenMonsters();
    }
}

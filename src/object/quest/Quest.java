package object.quest;
import object.chest.Chest;

public class Quest {
    private String name;
    private int lvl;
    private int xp;
    private int gold;
    boolean chestFound = false;
    private Chest chest;
    private String rewardString;

    public Quest(String name, int lvl) {
        this.name = name;
        this.lvl = lvl;
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

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", lvl=" + lvl +
                ", xp=" + xp +
                ", gold=" + gold +
                '}';
    }

    public void isChest() {
        double randChest = 1 + (Math.random() * (100 - 1));

        if (Double.compare(randChest, 11*getLvl()) < 0) {
            double randChestTemp = 1 + (Math.random() * (5 - 1));
            int randChestRank = (int) randChestTemp;
            this.setChest(new Chest(Math.round(randChestRank)));
            setChestFound(true);
        }
        else {
            setChestFound(false);
        }
    }

    public void reward(int lvl) {
        setGold(lvl + 10);
        setXp(lvl * 10);
    }

    public void goOnQuest() {
        reward(getLvl());
        isChest();
        questComplete();
    }

    public void questComplete() {

        rewardString = "Tu as gagné " + this.getXp() + " points d'xp\nAinsi que " + this.getGold() + " pièces d'or";
        if (isChestFound()) {
            System.out.println(this.getChest().getRank());
            rewardString = rewardString + "\nWow tu as été craiment chanceux; tu as obtenu un coffre de rang " + this.getChest().getRank();
        }

        System.out.println(rewardString);
    }
}

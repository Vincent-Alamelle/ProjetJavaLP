package object.expedition;

import init.Init;
import object.monster.Monster;

public class Expedition implements Runnable {
    private String nameExpe;
    private int lvl;
    private Monster playerMonster;

    public Expedition(String nameExpe, int lvl, Monster playerMonster) {
        this.nameExpe = nameExpe;
        this.lvl = lvl;
        this.playerMonster = playerMonster;
    }

    public String getNameExpe() {
        return nameExpe;
    }

    public void setNameExpe(String nameExpe) {
        this.nameExpe = nameExpe;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Monster getPlayerMonster() {
        return playerMonster;
    }

    public void setPlayerMonster(Monster playerMonster) {
        this.playerMonster = playerMonster;
    }

    @Override
    public void run() {
        long timeBegin = System.currentTimeMillis();
        while (playerMonster.getCurrentHealth() > 0) {
            playerMonster.setCurrentHealth(playerMonster.getCurrentHealth() - 1);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                long timeEnd = System.currentTimeMillis();
                int timeSpent = (int) ((timeEnd - timeBegin) / 1000);

                Init.player.addGold(timeSpent);
                playerMonster.addExperience(timeSpent/2);
                Init.player.addFragmentStone(timeSpent/10);
                System.out.println("Votre monstre est revenu.\nIl vous a rapporté " + timeSpent + " Gold.\nIl a aussi gagné " + timeSpent/2 + " points d'expérience\nIl a aussi trouvé " + timeSpent/10 + " fragments de pierres d'invocation");
            }

        }
        System.out.println(playerMonster.getName() + " n'est pas venu à bout de son expédition et est revenu bredouille");
        Init.player.regenMonsters();
    }
}

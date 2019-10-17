package object.expedition;

import object.monster.Monster;
import object.player.Player;

public class Expedition implements Runnable {
    private int lvl;
    private Monster playerMonster;

    public Expedition(int lvl, Monster playerMonster) {
        this.lvl = lvl;
        this.playerMonster = playerMonster;
    }

    private int getLvl() {
        return lvl;
    }

    @Override
    public void run() {
        long timeBegin = System.currentTimeMillis();
        while (playerMonster.getCurrentHealth() > 0) {
            switch (this.getLvl()){
                case 1: playerMonster.setCurrentHealth(playerMonster.getCurrentHealth() - 1);
                    break;
                case  2: playerMonster.setCurrentHealth(playerMonster.getCurrentHealth() - 2);
                    break;
                case  3: playerMonster.setCurrentHealth(playerMonster.getCurrentHealth() - 3);
                    break;
            }
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                long timeEnd = System.currentTimeMillis();
                int timeSpent = (int) ((timeEnd - timeBegin) / 1000);

                Player.getInstance().addGold(timeSpent);
                playerMonster.addExperience(timeSpent/2);
                Player.getInstance().addFragmentStone(timeSpent/10);
                System.out.println("Votre monstre est revenu.\nIl vous a rapporté " + timeSpent + " Gold.\nIl a aussi gagné " + timeSpent/2 + " points d'expérience\nIl a aussi trouvé " + timeSpent/10 + " fragments de pierres d'invocation");
            }

        }
        System.out.println(playerMonster.getName() + " n'est pas venu à bout de son expédition et est revenu bredouille");
        Player.getInstance().regenMonsters();
    }
}

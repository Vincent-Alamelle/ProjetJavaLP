package object.utils;

import constante.ConstanteInt;
import constante.ConstanteString;
import init.Init;
import object.monster.Monster;

import java.util.ArrayList;

public class Utils {
    public static ArrayList<Monster> getMonsterByRank(int rank){
        ArrayList<Monster> potentialMonsters = new ArrayList<>();
        for (int i = 0; i < Init.monsters.size(); ++i) {
            if (Init.monsters.get(i).getRank() == rank){
                potentialMonsters.add(Init.monsters.get(i));
            }
        }
        return potentialMonsters;
    }

    public static Monster getMonsterRandomly(ArrayList<Monster> monsters){
        double rand = (Math.random() * monsters.size());
        if (monsters.get((int)rand).getName().equals(ConstanteString.SLIME.toString()))
            return Init.fabriqueSlime.getMonster();
        else if (monsters.get((int)rand).getName().equals(ConstanteString.SUCCUBUS.toString()))
            return Init.fabriqueSuccubus.getMonster();
        else if (monsters.get((int)rand).getName().equals(ConstanteString.CABIRE.toString()))
            return Init.fabriqueCabire.getMonster();
        else if (monsters.get((int)rand).getName().equals(ConstanteString.DRAGONET.toString()))
            return Init.fabriqueDragonet.getMonster();
        else if (monsters.get((int)rand).getName().equals(ConstanteString.SATYR.toString()))
            return Init.fabriqueSatyr.getMonster();
        return null;
    }

    public static boolean fight(ArrayList<Monster> playerMonster, ArrayList<Monster> mobs){
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.addAll(playerMonster);
        monsters.addAll(mobs);
        while(true){
            for (int i = 0; i < monsters.size(); ++i) {
                if (monsters.get(i).getTurnBar() == ConstanteInt.MAX_SPEED.getValeur()-monsters.get(i).getSpeed()){
                    if (monsters.get(i).isPlayer()){
                        double rand = (Math.random() * mobs.size());
                        monsters.get(i).attack(mobs.get((int) rand));
                        monsters.get(i).setTurnBar(0);
                        if (mobs.get((int) rand).getCurrentHealth() <= 0) {
                            mobs.remove((int) rand);
                            if (mobs.size() == 0)
                                break;
                            monsters.remove(monsters.get(i));
                        }
                    }
                    else {
                        double rand = (Math.random() * playerMonster.size());
                        monsters.get(i).attack(playerMonster.get((int) rand));
                        monsters.get(i).setTurnBar(0);
                        if (playerMonster.get((int) rand).getCurrentHealth() <= 0){
                            playerMonster.remove((int) rand);
                            monsters.remove(monsters.get(i));
                            if (playerMonster.size() == 0)
                                break;
                        }
                    }
                }
                else
                    monsters.get(i).setTurnBar(monsters.get(i).getTurnBar()+1);
                if (playerMonster.size() == 0 || mobs.size() == 0)
                    break;
            }
            if (playerMonster.size() == 0 || mobs.size() == 0)
                break;
        }
        if (playerMonster.size() > 0)
            return true;
        else
            return false;
    }
}

package object.utils;

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
        double rand = 1+ (Math.random() * ((monsters.size()-1)-1));
        return monsters.get((int)rand);
    }
}

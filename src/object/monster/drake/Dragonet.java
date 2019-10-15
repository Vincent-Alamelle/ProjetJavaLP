package object.monster.drake;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

public class Dragonet extends Monster {
    public Dragonet(int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        super(ConstanteString.DRAGONET.toString(), ConstanteString.DRAKE.toString(), healthMax, attack, defense, speed,  level, experience, rank, element);
    }
    public Dragonet() {
    }
}



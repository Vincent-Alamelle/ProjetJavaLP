package object.monster.demon;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

public class Satyr extends Monster {
    public Satyr(int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        super(ConstanteString.SATYR.toString(), ConstanteString.DEMON.toString(), healthMax, attack, defense, speed, level, experience, rank, element);
    }

    public Satyr() {
    }
}

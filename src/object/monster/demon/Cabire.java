package object.monster.demon;

import constante.ConstanteString;
import object.monster.Monster;

public class Cabire extends Monster {
    public Cabire(int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        super(ConstanteString.CABIRE.toString(), ConstanteString.DEMON.toString(), healthMax, attack, defense, speed, level, experience, rank, element);
    }
}

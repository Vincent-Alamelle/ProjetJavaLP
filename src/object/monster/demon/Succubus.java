package object.monster.demon;

import constante.ConstanteString;
import object.monster.Monster;

public class Succubus extends Monster {
    public Succubus(int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        super(ConstanteString.SUCCUBUS.toString(), ConstanteString.DEMON.toString(), healthMax, attack, defense, speed, level, experience, rank, element);
    }

    public Succubus() {
    }

}

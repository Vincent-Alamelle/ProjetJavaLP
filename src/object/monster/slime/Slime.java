package object.monster.slime;

import constante.ConstanteString;
import object.monster.Monster;

public class Slime extends Monster {
    public Slime(int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        super(ConstanteString.SLIME.toString(), ConstanteString.SLIME.toString(), healthMax, attack, defense, speed, level, experience, rank,element);
    }
}

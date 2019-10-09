package object.monster.demon;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

public class Cabire extends Monster {

    public Cabire(int healthMax, int attack, int defense, int speed, int level, int experience, int rank) {
        super(ConstanteString.DEMON.toString(), healthMax, attack, defense, speed, level, experience, rank);
    }

    @Override
    protected void setHealthbyLevelAndRank(){
        setHealthMax(ConstanteInt.CABIRE_HEALTHMAX.getValeur() +(this.getLevel()*10*this.getRank()));
    }

    @Override
    protected void setAttackbyLevelAndRank() {
        setAttack(ConstanteInt.CABIRE_ATTACK.getValeur() +(this.getLevel()*5*this.getRank()));
    }

    @Override
    protected void setDefensebyLevelAndRank() {
        setDefense(ConstanteInt.CABIRE_DEFENSE.getValeur() +(this.getLevel()*4*this.getRank()));
    }

    public Cabire() {
    }
}

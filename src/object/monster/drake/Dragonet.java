package object.monster.drake;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

public class Dragonet extends Monster {
    public Dragonet(int healthMax, int attack, int defense, int speed, int level, int experience, int rank) {
        super(ConstanteString.DRAKE.toString(), healthMax, attack, defense, speed, level, experience, rank);
    }

    @Override
    protected void setHealthbyLevelAndRank(){
        setHealthMax(ConstanteInt.DRAGONET_HEALTHMAX.getValeur() +(this.getLevel()*10*this.getRank()));
    }

    @Override
    protected void setAttackbyLevelAndRank() {
        setAttack(ConstanteInt.DRAGONET_ATTACK.getValeur() +(this.getLevel()*5*this.getRank()));
    }

    @Override
    protected void setDefensebyLevelAndRank() {
        setDefense(ConstanteInt.DRAGONET_DEFENSE.getValeur() +(this.getLevel()*4*this.getRank()));
    }

    public Dragonet() {
    }
}



package object.monster.demon;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

public class Succubus extends Monster {
    public Succubus(int healthMax, int attack, int defense, int speed, int level, int experience, int rank) {
        super(ConstanteString.SUCCUBUS.toString(), ConstanteString.DEMON.toString(), healthMax, attack, defense, speed, level, experience, rank);
    }

    @Override
    protected void setHealthbyLevelAndRank(){
        setHealthMax(ConstanteInt.SUCCUBUS_HEALTHMAX.getValeur() +(this.getLevel()*10*this.getRank()));
    }

    @Override
    protected void setAttackbyLevelAndRank() {
        setAttack(ConstanteInt.SUCCUBUS_ATTACK.getValeur() +(this.getLevel()*5*this.getRank()));
    }

    @Override
    protected void setDefensebyLevelAndRank() {
        setDefense(ConstanteInt.SUCCUBUS_DEFENSE.getValeur() +(this.getLevel()*4*this.getRank()));
    }

    public Succubus() {
    }

}

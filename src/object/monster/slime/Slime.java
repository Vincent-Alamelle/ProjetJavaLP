package object.monster.slime;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

public class Slime extends Monster {
    public Slime(int healthMax, int attack, int defense, int speed, int level, int experience, int rank, String element) {
        super(ConstanteString.SLIME.toString(), ConstanteString.SLIME.toString(), healthMax, attack, defense, speed, level, experience, rank,element);
    }

    @Override
    protected void setHealthbyLevelAndRank(){
        setHealthMax(ConstanteInt.SLIME_HEALTHMAX.getValeur() +(this.getLevel()*10*this.getRank()));
    }

    @Override
    protected void setAttackbyLevelAndRank() {
        setAttack(ConstanteInt.SLIME_ATTACK.getValeur() +(this.getLevel()*5*this.getRank()));
    }

    @Override
    protected void setDefensebyLevelAndRank() {
        setDefense(ConstanteInt.SLIME_DEFENSE.getValeur() +(this.getLevel()*4*this.getRank()));
    }

    public Slime() {
    }
}

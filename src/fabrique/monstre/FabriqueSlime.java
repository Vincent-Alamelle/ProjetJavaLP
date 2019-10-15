package fabrique.monstre;

import constante.ConstanteInt;
import object.monster.Monster;
import object.monster.slime.Slime;

public class FabriqueSlime extends FabriqueMonstre {
    @Override
    protected Monster createMonster(String element) {
        return new Slime(ConstanteInt.SLIME_HEALTHMAX.getValeur(), ConstanteInt.SLIME_ATTACK.getValeur(), ConstanteInt.SLIME_DEFENSE.getValeur(),
                ConstanteInt.SLIME_SPEED.getValeur(), ConstanteInt.SLIME_LEVEL.getValeur(), ConstanteInt.SLIME_EXPERIENCE.getValeur(),
                ConstanteInt.SLIME_RANK.getValeur(), element);
    }
}

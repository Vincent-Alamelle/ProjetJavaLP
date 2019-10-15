package fabrique.monstre;

import constante.ConstanteInt;
import object.monster.Monster;
import object.monster.drake.Dragonet;

public class FabriqueDragonet extends FabriqueMonstre {
    @Override
    protected Monster createMonster(String element) {
        return new Dragonet(ConstanteInt.DRAGONET_HEALTHMAX.getValeur(), ConstanteInt.DRAGONET_ATTACK.getValeur(), ConstanteInt.DRAGONET_DEFENSE.getValeur(),
                ConstanteInt.DRAGONET_SPEED.getValeur(), ConstanteInt.DRAGONET_LEVEL.getValeur(), ConstanteInt.DRAGONET_EXPERIENCE.getValeur(),
                ConstanteInt.DRAGONET_RANK.getValeur(),element);
    }
}

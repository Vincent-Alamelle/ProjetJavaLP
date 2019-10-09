package fabrique.monstre;

import constante.ConstanteInt;
import object.monster.Monster;
import object.monster.drake.Dragonet;

public class FabriqueDragonet extends FabriqueMonstre {
    @Override
    protected Monster createMonster() {
        return new Dragonet(ConstanteInt.DRAGONNET_HEALTHMAX.getValeur(), ConstanteInt.DRAGONNET_ATTACK.getValeur(), ConstanteInt.DRAGONNET_DEFENSE.getValeur(),
                ConstanteInt.DRAGONNET_SPEED.getValeur(), ConstanteInt.DRAGONNET_LEVEL.getValeur(), ConstanteInt.DRAGONNET_EXPERIENCE.getValeur(), ConstanteInt.DRAGONNET_RANK.getValeur());
    }
}

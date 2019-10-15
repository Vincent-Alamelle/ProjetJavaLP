package fabrique.monstre;

import constante.ConstanteInt;
import object.monster.Monster;
import object.monster.demon.Succubus;

public class FabriqueSuccubus extends FabriqueMonstre {
    @Override
    protected Monster createMonster(String element) {
        return new Succubus(ConstanteInt.SUCCUBUS_HEALTHMAX.getValeur(), ConstanteInt.SUCCUBUS_ATTACK.getValeur(), ConstanteInt.SUCCUBUS_DEFENSE.getValeur(),
                ConstanteInt.SUCCUBUS_SPEED.getValeur(), ConstanteInt.SUCCUBUS_LEVEL.getValeur(), ConstanteInt.SUCCUBUS_EXPERIENCE.getValeur(),
                ConstanteInt.SUCCUBUS_RANK.getValeur(),element);
    }
}

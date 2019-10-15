package fabrique.monstre;

import constante.ConstanteInt;
import object.monster.Monster;
import object.monster.demon.Cabire;

public class FabriqueCabire extends FabriqueMonstre {
    @Override
    protected Monster createMonster(String element) {
        return new Cabire(ConstanteInt.CABIRE_HEALTHMAX.getValeur(), ConstanteInt.CABIRE_ATTACK.getValeur(), ConstanteInt.CABIRE_DEFENSE.getValeur(),
                ConstanteInt.CABIRE_SPEED.getValeur(), ConstanteInt.CABIRE_LEVEL.getValeur(), ConstanteInt.CABIRE_EXPERIENCE.getValeur(),
                ConstanteInt.CABIRE_RANK.getValeur(), element);
    }
}

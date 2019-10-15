package fabrique.monstre;

import constante.ConstanteInt;
import object.monster.Monster;
import object.monster.demon.Satyr;

public class FabriqueSatyr extends FabriqueMonstre{
    @Override
    protected Monster createMonster(String element) {
        return new Satyr(ConstanteInt.SATYR_HEALTHMAX.getValeur(), ConstanteInt.SATYR_ATTACK.getValeur(), ConstanteInt.SATYR_DEFENSE.getValeur(),
                ConstanteInt.SATYR_SPEED.getValeur(), ConstanteInt.SATYR_LEVEL.getValeur(), ConstanteInt.SATYR_EXPERIENCE.getValeur(),
                ConstanteInt.SATYR_RANK.getValeur(), element);
    }
}

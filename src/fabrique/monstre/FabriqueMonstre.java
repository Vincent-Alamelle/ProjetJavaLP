package fabrique.monstre;

import object.monster.Monster;

public abstract class FabriqueMonstre {
    public Monster getMonster(){
        return createMonster();
    }

    protected abstract Monster createMonster();
}

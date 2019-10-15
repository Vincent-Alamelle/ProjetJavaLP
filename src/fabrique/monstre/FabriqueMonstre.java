package fabrique.monstre;

import object.monster.Monster;

public abstract class FabriqueMonstre {
    public Monster getMonster(){
        String element;
        double rand = (Math.random() * 4);
        switch ((int) rand){
            case 0: element = "vent";
                break;
            case 1: element = "feu";
                break;
            case 2: element = "eau";
                break;
            default: element = "terre";
                break;
        }
        return createMonster(element);
    }

    protected abstract Monster createMonster(String element);
}

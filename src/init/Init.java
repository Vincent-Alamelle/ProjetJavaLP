package init;

import fabrique.monstre.*;
import object.monster.Monster;

public class Init {
    public static final FabriqueMonstre fabriqueSuccubus = new FabriqueSuccubus();
    public static final FabriqueMonstre fabriqueDragonet = new FabriqueDragonet();
    public static final FabriqueMonstre fabriqueSlime = new FabriqueSlime();
    public static Monster succubus;
    public static Monster slime;
    public static Monster dragonet;

    public static void Initialise(){
        succubus = fabriqueSuccubus.getMonster();
        slime = fabriqueSlime.getMonster();
        dragonet = fabriqueDragonet.getMonster();
    }
}

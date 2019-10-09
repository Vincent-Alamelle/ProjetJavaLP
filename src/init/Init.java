package init;

import fabrique.monstre.*;
import object.monster.Monster;

import java.util.ArrayList;

public class Init {
    public static final FabriqueMonstre fabriqueSuccubus = new FabriqueSuccubus();
    public static final FabriqueMonstre fabriqueDragonet = new FabriqueDragonet();
    public static final FabriqueMonstre fabriqueSlime = new FabriqueSlime();
    public static final FabriqueMonstre fabriqueSatyr = new FabriqueSatyr();
    public static final FabriqueMonstre fabriqueCabire = new FabriqueCabire();
    public static Monster succubus;
    public static Monster slime;
    public static Monster dragonet;
    public static Monster satyr;
    public static Monster cabire;
    public static ArrayList<Monster> monsters = new ArrayList<>();

    public static void initialise(){
        succubus = fabriqueSuccubus.getMonster();
        slime = fabriqueSlime.getMonster();
        dragonet = fabriqueDragonet.getMonster();
        satyr = fabriqueSatyr.getMonster();
        cabire = fabriqueCabire.getMonster();
        monsters.add(succubus);
        monsters.add(slime);
        monsters.add(dragonet);
        monsters.add(satyr);
        monsters.add(cabire);
    }
}

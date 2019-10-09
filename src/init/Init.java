package init;

import fabrique.monstre.*;
import object.monster.Monster;

import java.util.ArrayList;

public class Init {
    public static final FabriqueMonstre fabriqueSuccubus = new FabriqueSuccubus();
    public static final FabriqueMonstre fabriqueDragonet = new FabriqueDragonet();
    public static final FabriqueMonstre fabriqueSlime = new FabriqueSlime();
    public static Monster succubus;
    public static Monster slime;
    public static Monster dragonet;
    public static ArrayList<Monster> monsters = new ArrayList<>();

    public static void initialise(){
        succubus = fabriqueSuccubus.getMonster();
        slime = fabriqueSlime.getMonster();
        dragonet = fabriqueDragonet.getMonster();
        monsters.add(succubus);
        monsters.add(slime);
        monsters.add(dragonet);
    }
}

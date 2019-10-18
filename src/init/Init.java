package init;

import fabrique.item.FabriqueItem;
import fabrique.monstre.*;
import object.monster.Monster;
import object.player.Player;

import java.util.ArrayList;

public class Init {
    public static final FabriqueMonstre fabriqueSuccubus = new FabriqueSuccubus();
    public static final FabriqueMonstre fabriqueDragonet = new FabriqueDragonet();
    public static final FabriqueMonstre fabriqueSlime = new FabriqueSlime();
    public static final FabriqueMonstre fabriqueSatyr = new FabriqueSatyr();
    public static final FabriqueMonstre fabriqueCabire = new FabriqueCabire();
    public static final FabriqueItem fabriqueItem = new FabriqueItem();
    public static ArrayList<Monster> monsters = new ArrayList<>();
    public static ArrayList<Thread> listThread = new ArrayList<>();
    public static ArrayList<Monster> listMonster = new ArrayList<>();

    public static void initialise(){
        monsters.add(fabriqueSuccubus.getMonster());
        monsters.add(fabriqueSlime.getMonster());
        monsters.add(fabriqueDragonet.getMonster());
        monsters.add(fabriqueSatyr.getMonster());
        monsters.add(fabriqueCabire.getMonster());
        Player.getInstance().addFragmentStone(20);
    }
}

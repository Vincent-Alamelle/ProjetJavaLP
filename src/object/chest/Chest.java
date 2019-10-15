package object.chest;

import constante.ConstanteInt;
import init.Init;
import object.item.Item;

public class Chest {
    private int rank, gold, invocationShard;
    private Item item;

    public Chest(int rank) {
        this.rank = rank;
        this.gold = ConstanteInt.GOLD_IN_CHEST.getValeur()*3*this.getRank();
        this.invocationShard = ConstanteInt.INVOCATIONSHARD_IN_CHEST.getValeur()*this.getRank();
        this.item = Init.fabriqueItem.getItem(this.getRank());
    }

    public int getGold() {
        return gold;
    }
    public int getInvocationShard() {
        return invocationShard;
    }
    public Item getItem() {
        return item;
    }
    public int getRank() {
        return rank;
    }

}

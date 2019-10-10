package fabrique.item;


import object.item.Item;

import java.util.ArrayList;
import java.util.Arrays;


public class FabriqueItem {
    public Item getItem(int rank){
        return createItem(rank);
    }

    private Item createItem(int rank){
        ArrayList<String> pieces = new ArrayList<String>(Arrays.asList("head","weapon","chestplate","gloves","pants","boots"));
        double rand = Math.random() * pieces.size();
        Item item = new Item(pieces.get((int) rand),rank);
        item.setStat();
        return item;
    }
}

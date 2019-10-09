package object.item;

public class Item {
    private String name;
    private int rank;

    public Item(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

package object.plot;

import object.monster.Monster;

import java.util.ArrayList;

public class Voliere extends Plot {
    private int height;

    public Voliere(String name, String cleanliness, double area, int nbMax, int nbAnimals, ArrayList<Monster> animals, int height) {
        super(name, cleanliness, area, nbMax, nbAnimals, animals);
        this.height = height;
    }

    public Voliere() {

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

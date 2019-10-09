package object.plot;

import object.monster.Monster;

import java.util.ArrayList;

public class EnclosStandard extends Plot {
    public EnclosStandard(String name, String cleanliness, double area, int nbMax, int nbAnimals, ArrayList<Monster> animals) {
        super(name, cleanliness, area, nbMax, nbAnimals, animals);
    }

    public EnclosStandard() {
    }
}

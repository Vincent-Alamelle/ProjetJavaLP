package object.plot;

import constante.ConstanteInt;
import constante.ConstanteString;
import object.monster.Monster;

import java.util.ArrayList;

public class Aquarium extends Enclos {
    private double depth, salinity;

    public Aquarium(String name, String cleanliness, double area, int nbMax, int nbAnimals, ArrayList<Monster> animals, double depth, double salinity) {
        super(name, cleanliness, area, nbMax, nbAnimals, animals);
        this.depth = depth;
        this.salinity = salinity;
    }

    public Aquarium() {
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getSalinity() {
        return salinity;
    }

    public void setSalinity(double salinity) {
        this.salinity = salinity;
    }

}

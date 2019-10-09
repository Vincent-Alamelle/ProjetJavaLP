package object.plot;

import object.monster.Monster;

import java.util.ArrayList;

public abstract class Plot {
    private String name, cleanliness;
    private double area;
    private int nbMax, nbAnimals;
    private ArrayList<Monster> animals;

    public Plot(String name, String cleanliness, double area, int nbMax, int nbAnimals, ArrayList<Monster> animals) {
        this.name = name;
        this.cleanliness = cleanliness;
        this.area = area;
        this.nbMax = nbMax;
        this.nbAnimals = nbAnimals;
        this.animals = animals;
    }

    public Plot() {
    }

    public void addAnimal(Monster animal){
        animals.add(animal);
    }
    public void removeAnimal(Monster animal){
        animals.remove(animal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public int getNbAnimals() {
        return nbAnimals;
    }

    public void setNbAnimals(int nbAnimals) {
        this.nbAnimals = nbAnimals;
    }

    public ArrayList<Monster> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Monster> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "object.plot{" +
                "name='" + name + '\'' +
                ", cleanliness='" + cleanliness + '\'' +
                ", area=" + area +
                ", nbMax=" + nbMax +
                ", nbAnimals=" + nbAnimals +
                ", animals=" + animals +
                '}';
    }
}

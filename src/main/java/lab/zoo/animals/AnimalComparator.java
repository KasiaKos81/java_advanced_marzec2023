package lab.zoo.animals;

import lab.zoo.Animal;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        System.out.println("compare " + a1 + " and " + a2);
        return a1.getName().compareTo(a2.getName());
    }
}

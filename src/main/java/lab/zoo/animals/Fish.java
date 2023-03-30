package lab.zoo.animals;

import lab.zoo.Animal;

public abstract class Fish extends Animal {

    public Fish(String name, int mass) {
        super(name, mass);
    }

    @Override
    public void move() {
        System.out.println(this + " is swimming");
    }
}

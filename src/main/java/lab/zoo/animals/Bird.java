package lab.zoo.animals;

import lab.zoo.Animal;

public abstract class Bird extends Animal {

    public Bird(String name, int mass) {
        super(name, mass);
    }

    @Override
    public void move() {
        System.out.println(this + " is flying");
    }
}

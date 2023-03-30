package lab.zoo.animals.bird;


import lab.zoo.animals.Bird;

public class Kiwi extends Bird {
    public Kiwi(String name, int mass) {
        super(name, mass);
    }

    @Override
    public void move() {
        System.out.println(this + " is walking");
    }
}

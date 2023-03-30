package lab.zoo.animals.fish;

import lab.zoo.animals.Fish;

public class Oyster extends Fish {

    private String resource = "resource";

    public Oyster(String name, int mass) {
        super(name, mass);
    }

    public class Pearl {

        private String mass;

        public Pearl(String sand){
            this.mass = sand;
        }

        public String grow() {
            mass = mass + "[" + resource + "]";
            return mass;
        }
    }


}

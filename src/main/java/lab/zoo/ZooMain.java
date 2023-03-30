package lab.zoo;

import lab.zoo.animals.AnimalComparator;
import lab.zoo.animals.bird.Eagle;
import lab.zoo.animals.bird.Kiwi;
import lab.zoo.animals.bird.Parrot;
import lab.zoo.animals.fish.Merlin;
import lab.zoo.animals.fish.Oyster;
import lab.zoo.animals.fish.Shark;
import lab.zoo.animals.fish.Tuna;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ZooMain {

    public static void main(String[] args) {
        System.out.println("Let's visit zoo!");

        Eagle bielik = new Eagle("Bielik", 15);
        Eagle george = new Eagle("George", 13);
        Parrot ara = new Parrot("Ara", 3);
        Parrot ara2 = new Parrot("Ara", 3);

        Merlin nemo = new Merlin("Nemo", 199);
        Shark willy = new Shark("Willy", 299);
        Kiwi joe = new Kiwi("Joe", 5);
        Tuna jack = new Tuna("Jack", 50);

//        Collection <Animal> animals = new HashSet<>();
//        animals.add(bielik);
//        animals.add(george);
//        animals.add(ara);
//        animals.add(ara2);
//        animals.add(nemo);
//        animals.add(willy);
//        animals.add(joe);
//        animals.add(jack);
//
//        for (Animal animal : animals) {
//            System.out.println("animal" + animal);
//        }

        //    Set zwierzaki = new HashSet();


        List<Animal> animals = new LinkedList<>();
        // new ArrayList<>()

        //   animals = Collections.unmodifiableList(animals);

        animals.add(bielik);
        animals.add(george);
        animals.add(ara);
        animals.add(0, ara2);
        animals.add(nemo);
        animals.add(willy);
        animals.add(joe);
        animals.add(jack);

//        Iterator<Animal> itr = animals.iterator();
//        while (itr.hasNext()) {
//            Animal animal = itr.next();
//            if (animal.getName().equals("Nemo")) {
//                itr.remove();
//            }
//        } -> też jakieś tam inneg rozwiązanie

        // filtering
        Predicate<Animal> predicate = a -> a.getName().equalsIgnoreCase("Nemo"); // lepsza opcja niż to niżej
       //         new Predicate<Animal>() {
        //    @Override
        //    public boolean test(Animal animal) {
         //       return animal.getName().equals("Nemo");
          //  }
      //  };
        animals.removeIf(predicate);

// sporting
        Comparator<Animal> animalComparator = (a1, a2) -> a1.getMass() - a2.getMass();
        //   Comparator<Animal> animalComparator = new AnimalComparator();
        //  Collections.sort(animals,(a1, a2)) -> a1.getMass()-a2.getMass());
        // animals.sort(animalComparator); -> alternatywne rozwiązanie

        // reviewing
        Consumer<Animal> animalConsumer = System.out::println;
        // a -> System.out.println(a);
        animals.forEach(animalConsumer);

       // reviewing
        for (Animal animal : animals) {
            System.out.println("animal" + animal);
        }

      //  Consumer<Animal> consumer = animal -> System.out.println("animal " + animal); -> inna opcja
        animals.forEach(animal -> System.out.println("animal " + animal));

        System.out.println("********************************");

        Animal animal = animals.get(4);
        System.out.println("animal 4 = " + animal);

        animal.eat("oat");

        Oyster oyster = new Oyster("Stasiek", 1);
        Oyster.Pearl pearl = oyster.new Pearl("sand");
        pearl.grow();
        pearl.grow();
        System.out.println("pearl mass: " + pearl.grow());


        System.out.println("done.");

    }
}

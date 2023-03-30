package lab.zoo;

import lab.zoo.animals.bird.Eagle;
import lab.zoo.animals.bird.Kiwi;
import lab.zoo.animals.bird.Parrot;
import lab.zoo.animals.fish.Merlin;
import lab.zoo.animals.fish.Shark;
import lab.zoo.animals.fish.Tuna;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ZooStreamMain {
    public static void main(String[] args) {
        System.out.println("Let's stream Zoo");

        Eagle bielik = new Eagle("Bielik", 15);
        Eagle george = new Eagle("George", 13);
        Parrot ara = new Parrot("Ara", 3);
        Parrot ara2 = new Parrot("Ara", 3);
        Merlin nemo = new Merlin("Nemo", 199);
        Shark willy = new Shark("Willy", 299);
        Kiwi joe = new Kiwi("Joe", 5);
        var jack = new Tuna("Jack", 50);

        List<Animal> animals = new LinkedList<>();
        animals.add(bielik);
        animals.add(george);
        animals.add(ara);
        animals.add(0, ara2);
        animals.add(nemo);
        animals.add(willy);
        animals.add(joe);
        animals.add(jack);

        Stream<Animal> stream = animals.stream();
//        if(!stream.isParallel()){
//            stream = stream.isParallel();
//        }

        var result = stream
                // operacje:
                // intermediate ops

                .distinct()
                .sorted((a1, a2) -> a1.getName().length() - a2.getName().length())
                .filter(a -> !a.getName().equalsIgnoreCase("nemo"))
                .map(a -> a.getName())
                .peek(a -> System.out.println("peek " + a))
                //   .limit(3)

                // terminal op
                //    .count();
                // .collect(Collectors.toList());
                //       .anyMatch(name -> name.contains("x")); // tutaj rezultatem jest boolean
                .findFirst();

        Supplier<RuntimeException> supplier = () -> new IllegalStateException("no value");
        System.out.println("result " + result.orElseThrow(supplier));

        Integer massSum = animals.stream()
                .map(a -> a.getMass())
                .reduce(0, (i1, i2) -> i1 + i2);
        System.out.println("mass summ is " + massSum);

        Stream<String> stringStream = Stream.generate(() -> "xyz"); // że nieskończony stream
        stringStream
                .limit(10)
                .forEach(System.out::println);

        Stream<Integer> integerStream = Stream.iterate(1, i -> i + 1);

        integerStream
                .limit(10)
                .forEach(System.out::println);

        IntStream intStream = IntStream.iterate(1, i -> i + 1);
        OptionalDouble optionalDouble = intStream
                .limit(13)
                .average();

        Set<String> abc = Set.of("a", "b", "c");
        Set<String> xyz = Set.of("x", "y", "z");

        Stream<Set<String>> all = Stream.of(abc, xyz);
        all
                .flatMap(set -> set.stream())
                .forEach(System.out::println);

        // collect to map

        Map<String, Animal> animalMap= animals.stream()
                .distinct()
                .collect(Collectors.toMap(a -> a.getName(), a -> a));

        System.out.println("done");


    }

}

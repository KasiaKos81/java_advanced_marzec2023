package lab.dynamic;

import lab.zoo.Animal;
import lab.zoo.animals.fish.Merlin;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Stream;

public class ReflectMain {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        String className = "lab.zoo.animals.fish.Merlin";
        String name = "Nemo";
        int mass = -303;

        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Object o = constructor.newInstance(name, mass);

        System.out.println("obiekt= " + o);
        if(o instanceof Animal){
            Animal a = (Animal) o;

//            getFieldStream(clazz)
//                    .forEach(f -> {
//                      Positive positive = f.getAnnotation(Positive.class);
//                      if(positive !=null) {
//                          System.out.println("annotation Positive found on a field " + f.getName());
//                          try {
//                              Object value = f.get(a);
//                              if(value instanceof Integer){
//                                  int ineValue = (int) value;
//                                  if(ineValue<0  || ineValue > positive.max()){
//                                      throw new RuntimeException("constrain violation on field" +f.getName());
//                                  }
//                              }
//                          } catch (IllegalAccessException e){
//                              throw new RuntimeException(e);
//                          }
//                        }
//                    });

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Animal>> violations = validator.validate(a);
            System.out.println("violations " + violations);

            System.out.println("animal created " + a.getClass().getSimpleName()
            + "'" + a.getName() + "," + a.getMass());

            getFieldStream(clazz)
                    .filter(f -> f.getName().equals("mass"))
                    .forEach(f -> {
                        try {

                            f.setAccessible(true); // jak pole jest private to teraz umożliwiamy jego odczyt
                            f.set(a, 102); // nadpisujemy wartość

                            Object value = f.get(a);
                            System.out.println(("filed " + f.getName() + " has value " + value));

                        } catch (IllegalAccessException e){
                            throw new RuntimeException(e);
                        }
                    });
        } else {
            System.out.println("unexpected object type");
        }
    }
    private static Stream<Field> getFieldStream(Class clazz){
        Stream<Field> stream = Stream.empty();
        while(clazz!=null){
            stream = Stream.concat(stream, Stream.of(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return stream;
    }
}


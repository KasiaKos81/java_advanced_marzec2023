package lab.dynamic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // dodawanie adnotacji do konkretnego pola
@Retention(RetentionPolicy.RUNTIME)
public @interface Positive {

    int value();
    int max() default 100;


}

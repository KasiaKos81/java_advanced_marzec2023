package lab.valid;

@FunctionalInterface
public interface Validator <T> {
    boolean validate(T t);

    default String getDescription() {
        return "whatever";
    }

    static String foo(){
        return "foo";
    }
}

package lab.valid;

public class ValidatorMain {
    public static void main(String[] args) {

        int value = 13;

        Validator<Integer> validator = getValidator();

        boolean result = validator.validate(value);
        System.out.println("result = " + result);

    }

    public static Validator<Integer> getValidator(){
        return v -> v >= 0 && v <= 100;
    }
}

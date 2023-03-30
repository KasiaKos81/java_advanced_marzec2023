package lab.valid;

public class PercentagerValidator implements Validator<Integer>{
    @Override
    public boolean validate(Integer value) {
        return value >= 0 && value <= 100;
    }
}

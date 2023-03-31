package lab.concurrency.charger;

public class Electricity {

    private static Electricity instance;

    private boolean on = false;

    private Electricity(){}

    public static Electricity getInstance(){
        if(instance==null){
            instance = new Electricity();
        }
        return instance;
    }

    public void turnOn(){
        on = true;
    }

    public void turnOff(){
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}

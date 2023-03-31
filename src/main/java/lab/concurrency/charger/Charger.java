package lab.concurrency.charger;


public class Charger {

    private static final int POWER = 3;

    public void chargeDevice(Phone p, int hours) {
         p.charge(hours*POWER);
    }
}

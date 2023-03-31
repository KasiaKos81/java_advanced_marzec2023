package lab.concurrency.charger;

public class ChargerStarter {

    public static void main(String[] args) {

        //Electricity.getInstance().turnOn();

        Charger samsungCharger = new Charger();
        Charger appleCharger = new Charger();

        Phone samsung = new Phone(50, "Samsung S11");
        Phone apple = new Phone(35, "Iphone XR");

        samsungCharger.chargeDevice(samsung, 8);
        appleCharger.chargeDevice(apple, 10);

        System.out.println("done.");

    }
}

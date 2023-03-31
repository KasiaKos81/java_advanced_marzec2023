package lab.concurrency.charger;

public class Phone {

    private int battery;

    private String name;

    public Phone(int battery, String name) {
        this.battery = battery;
        this.name = name;
    }

    public void charge(int circles) {
        for (int i = 1; i <= circles; i++) {

            System.out.println("charging phone " + this);
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            battery++;
        }
        System.out.println("charging finished: " + this);
    }

    public int getBattery() throws IllegalArgumentException{
        return battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "battery=" + battery +
                ", name='" + name + '\'' +
                '}';
    }
}

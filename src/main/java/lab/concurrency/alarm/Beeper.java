package lab.concurrency.alarm;

public class Beeper extends Alarm {

    protected void specificAlarm() {
        for(int i=0; i<30; i++){
            System.out.println("BEEP");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

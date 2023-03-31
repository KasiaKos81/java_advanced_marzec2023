package lab.concurrency.alarm;

public class Flash extends Alarm {
    @Override
    protected void specificAlarm() {
        for(int i=0; i<20; i++){
            System.out.println("FLASH");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

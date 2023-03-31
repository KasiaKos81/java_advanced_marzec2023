package lab.concurrency.alarm;

public abstract class Alarm extends Thread{

    public void alarm(){

        specificAlarm();
    }

    protected abstract void specificAlarm();

    @Override
    public void run() {
        alarm();
    }
}

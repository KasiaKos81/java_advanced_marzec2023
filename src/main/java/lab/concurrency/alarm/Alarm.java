package lab.concurrency.alarm;

import java.util.Random;
import java.util.concurrent.Callable;

public abstract class Alarm implements Callable<Boolean> {

    public void alarm(){

        specificAlarm();
    }

    protected abstract void specificAlarm();

    @Override
    public Boolean call() {
        alarm();
        return new Random().nextBoolean();
    }
}

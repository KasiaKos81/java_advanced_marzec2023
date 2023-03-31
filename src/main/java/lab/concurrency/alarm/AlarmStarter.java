package lab.concurrency.alarm;

import lab.concurrency.ThreadNamePrefixPrintStream;

import java.util.ArrayList;
import java.util.List;

public class AlarmStarter {

    public static void main(String[] args) {

        System.setOut(new ThreadNamePrefixPrintStream(System.out));

        List<Alarm> alarms = new ArrayList<>();
        alarms.add(new Beeper());
        alarms.add(new Flash());

        alarms.forEach(a->a.start());

        System.out.println("done.");
}
}

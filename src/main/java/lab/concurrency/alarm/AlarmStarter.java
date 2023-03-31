package lab.concurrency.alarm;

import lab.concurrency.ThreadNamePrefixPrintStream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class AlarmStarter {

    public static void main(String[] args) throws ExecutionException {

        System.setOut(new ThreadNamePrefixPrintStream(System.out));

        ExecutorService es = null; // executor service to wrapper

        List<Alarm> alarms = new ArrayList<>();
        alarms.add(new Beeper());
        alarms.add(new Flash());

    //    alarms.forEach(a-> new Thread(a).start()); // "a" to ten obiekt alarm

        //  alarms.forEach(a->es.execute(a));

        List<Future<Boolean>> futures = new ArrayList<>();
        alarms.forEach(a->futures.add(es.submit(a)));

        es.shutdown();

        futures.forEach(f->{
            try{
                boolean b = f.get();
                System.out.println("b= " + b);
            } catch (InterruptedException | ExecutionException e){
                throw new RuntimeException(e);
            }
        });

        System.out.println("done.");
}
}

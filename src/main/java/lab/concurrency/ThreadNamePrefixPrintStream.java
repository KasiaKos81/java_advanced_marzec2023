package lab.concurrency;

import java.io.OutputStream;
import java.io.PrintStream;


public class ThreadNamePrefixPrintStream extends PrintStream {


    public ThreadNamePrefixPrintStream(OutputStream os) {
        super(os);
    }

    @Override
    public void println(String x) {
        super.println(Thread.currentThread().getName() + " : " + x);
    }

    @Override
    public void println(Object x) {
        println(x.toString());
    }

    @Override
    public void println(int x) {
        println((Integer)x);
    }
}

package lab.concurrency.bank;

import lab.concurrency.ThreadNamePrefixPrintStream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountStarter {

    public static void main(String[] args) {

        System.setOut(new ThreadNamePrefixPrintStream(System.out));

        ExecutorService es = Executors.newFixedThreadPool(2);

        Account a = new Account(1000);

        DepositTask depositTask = new DepositTask(a);
        WithdrawTask withdrawTask = new WithdrawTask(a);

        es.execute(() -> depositTask.deposit()); // ta lambda to runnable
        es.execute(() -> withdrawTask.withdraw()); // ta lambda to uruchamia kolejny runable

        depositTask.deposit(); // deposit 1 bc 1 million times
        withdrawTask.withdraw();  // withdraw 1 bc 1 million times

        System.out.println("account: " + a.getAmount());

        es.shutdown();

    }
}

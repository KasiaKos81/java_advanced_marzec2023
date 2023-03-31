package lab.concurrency.bank;

import lab.concurrency.ThreadNamePrefixPrintStream;

public class AccountStarter {

    public static void main(String[] args) {

        System.setOut(new ThreadNamePrefixPrintStream(System.out));

        Account a = new Account(1000);

        DepositTask depositTask = new DepositTask(a);
        WithdrawTask withdrawTask = new WithdrawTask(a);

        depositTask.deposit();
        withdrawTask.withdraw();

        System.out.println("account: " + a.getAmount());

    }
}

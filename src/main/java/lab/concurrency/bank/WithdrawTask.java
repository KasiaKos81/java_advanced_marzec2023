package lab.concurrency.bank;

public class WithdrawTask {

    private Account account;

    public WithdrawTask(Account account) {
        this.account = account;
    }

    public void withdraw() {
        for(int i=0; i<1_000_000; i++){
            account.withdraw(1);
            if(i%10_000==0){
                System.out.println("withdraw:" + account.getAmount());
            }
        }
        System.out.println("after withdraw" + account.getAmount());
    }
}

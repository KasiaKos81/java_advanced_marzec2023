package lab.concurrency.bank;

public class DepositTask{

    private Account account;

    public DepositTask(Account account) {
        this.account = account;
    }


    public void deposit(){
        for(int i=0; i<1_000_000; i++){
            account.deposit(1);
            if(i%10_000==0){
                System.out.println("deposit:" + account.getAmount());
            }
        }

        System.out.println("after deposit: " + account.getAmount());

    }
}

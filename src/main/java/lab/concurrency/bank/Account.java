package lab.concurrency.bank;

public class Account {

    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public void deposit(int value){

        amount=amount+value;
    }

    public  void withdraw(int value){
        amount=amount-value;
    }

    public int getAmount() {
        return amount;
    }
}

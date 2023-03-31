package lab.concurrency.bank;

public class Account {

    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public void deposit(int value){

        amount=amount+value; // 1 operacja read, 2 oper calculate, 3 oper assign
    }

    public  void withdraw(int value){
        amount=amount-value;
    }

    public int getAmount() {
        return amount;
    }
}

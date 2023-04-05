public class T1G5 {
    public static void main(String[] args) {
        BankAccount account = new  BankAccount(100);
        System.out.println(account.deposit(50));
        System.out.println(account.withdraw(75));
        System.out.println(account.withdraw(75));
        System.out.println(account.deposit(50));

    }
}

interface Account{
    int deposit(int amount);
    boolean withdraw(int amount);
}

class BankAccount implements Account{
    private int balance;

    public BankAccount(int balance){
        this.balance = balance;
    }

    @Override
    public int deposit(int amount){
        balance += amount;
        return balance;
    }

    @Override
    public boolean withdraw(int amount){
        if(amount<=balance){
            balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }
}
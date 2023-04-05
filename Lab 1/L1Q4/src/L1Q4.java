import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class L1Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account1 account = new Account1();
        System.out.println("Enter id: ");
        account.setId(sc.nextInt());
        System.out.println("Enter name: ");
        account.setName(sc.next());
        System.out.println("Enter balance: ");
        account.setBalance(sc.nextDouble());
        System.out.println("Enter annual interest rate: ");
        account.setAnnualInterestRate(sc.nextDouble());

        Account1 account1 = new Account1(account.getId() , account.getName(), account.getBalance(), account.getAnnualInterestRate());
        System.out.println("Enter amount to withdraw: ");
        account1.withdraw(sc.nextDouble());
        System.out.println("Enter amount to deposit: ");
        account1.deposit(sc.nextDouble());
        System.out.println();
        System.out.println("Account details: ");
        System.out.println("Account holder name: " + account1.getName());
        System.out.println("Account interest rate: " + account1.getAnnualInterestRate());
        System.out.println("Account balance: " + account1.getBalance());

        System.out.println();
        System.out.println("Transactions: ");
        for(Transaction transactions : account1.transactions){
            System.out.println("Date: " + transactions.getDate());
            System.out.println("Type: " + transactions.getType());
            System.out.println("Amount: " + transactions.getAmount());
            System.out.println("Balance: " + transactions.getBalance());
            System.out.println("Description: " + transactions.getDescription());
            System.out.println();
        }



    }
}

class Transaction{
    public Date date;
    public char type;
    public double amount;
    public double balance;
    public String description;

        public Transaction(char type, double amount, double balance, String description){
            this.date = new Date();
            this.type = type;
            this.amount = amount;
            this.balance = balance;
            this.description = description;
        }

        public Date getDate(){
            return date;
        }

        public char getType(){
            return type;
        }

        public double getAmount(){
            return amount;
        }

        public double getBalance(){
            return balance;
        }

        public String getDescription(){
            return description;
        }
}

class Account1{
    private int id;
    private String name;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    ArrayList<Transaction> transactions;

    public Account1(){
        this.id = 0;
        this.name = "";
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
        this.transactions = new ArrayList<Transaction>();
    }

    public Account1(int id, String name, double balance, double annualInterestRate){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
        this.transactions = new ArrayList<Transaction>();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "Withdraw"));
        }
    }

    public void deposit(double amount){
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit"));
    }
}
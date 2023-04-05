import java.util.Scanner;

public class T3Q1 {
    public static void main(String[] args) {
        CandyMachine candyMachine = new CandyMachine();
    }
}

class Dispenser {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private int cart;

    public Dispenser(String name, double price, int quantity) {
        itemName = name;
        itemPrice = price;
        itemQuantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void decreaseItemQuantity(int itemQuantity) {
        this.itemQuantity -= itemQuantity;
    }

    public boolean addToCart(int itemQuantity) {
        if(itemQuantity>0 && itemQuantity<=this.itemQuantity) {
            cart += itemQuantity;
            decreaseItemQuantity(itemQuantity);
            return true;
        }
        else{
            System.out.println("Out of Stock");
            return false;
        }
    }

}

class CashRegister{
    private double total;
    private double cash;
    private double change;

    public CashRegister(){
        total = 0;
        cash = 0;
        change = 0;
    }

    public void add(double price){
        total += price;
    }

    public void pay(double cash){
        this.cash = cash;
        change = cash - total;
    }

    public double getTotal(){
        return total;
    }

    public double getCash(){
        return cash;
    }

    public double getChange(){
        return change;
    }

    public void reset(){
        total = 0;
        cash = 0;
        change = 0;
    }

    public void printReceipt(){
        System.out.println("Total: " + total);
        System.out.println("Cash: " + cash);
        System.out.println("Change: " + change);
    }


}

class CandyMachine{
    static Scanner sc = new Scanner(System.in);
    Dispenser [] dispenser = {new Dispenser("candy", 1.50, 10), new Dispenser("chip", 1.00, 10) , new Dispenser("gum" , 1.0 , 30) , new Dispenser("cookie" , 2.2 , 8)};
    CashRegister cashRegister = new CashRegister();

    public CandyMachine(){
        display();
    }

    public void display(){
        System.out.printf("%-10s%-10s%-10s%n", "Item", "Price", "Quantity");
        for(int i=0; i<dispenser.length; i++){
            System.out.printf("%-10s%-10.2f%-10d%n", dispenser[i].getItemName(), dispenser[i].getItemPrice(), dispenser[i].getItemQuantity());
        }
        buy();
    }

    public void buy(){
        System.out.println("Enter item: (0 for candy, 1 for chip, 2 for gum, 3 for cookie)");
        int choice = sc.nextInt();
        System.out.println("Enter quantity: ");
        int quantity = sc.nextInt();

        if(dispenser[choice].addToCart(quantity)){
            cashRegister.add(dispenser[choice].getItemPrice()*quantity);
        }

        System.out.println("Continue? (y/n)");
        String ans = sc.next();
        if(ans.equals("y")){
            display();
            buy();
        }
        else{
            cmPay();
        }


    }
    public void cmPay(){
        System.out.println("\nTotal: " + cashRegister.getTotal());
        System.out.println("Enter cash: ");
        double cash = sc.nextDouble();
        cashRegister.pay(cash);
        cashRegister.printReceipt();
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
Buy 100 shares at $10 each
Buy 50 shares at $20 each
Sell 50 shares at $20 each
Sell 60 shares at $30 each
Sell 50 shares at $35 each
 */

public class L7Q3 {
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> shareQueue = new LinkedList<>();
    static Queue<Integer> priceQueue = new LinkedList<>();
    static int totalCapitalGain = 0;

    public static void main(String[] args) {
        String query;
        do{
            System.out.print("\nEnter your query (In format 'Buy / Sell x shares at $y each'): ");
            query = sc.nextLine();
            if(query.contains("Buy")){
                buy(shareQueue, priceQueue, query);
            }else if(query.contains("Sell")){
                totalCapitalGain+= sell(shareQueue, priceQueue, query);
            }else{
                System.out.println("Invalid query");
            }
        } while (!query.equalsIgnoreCase("End"));
        System.out.println("Total capital gain: $" + totalCapitalGain);

    }

    static void buy(Queue<Integer> shareQueue, Queue<Integer> priceQueue, String query){
        int share = Integer.parseInt(query.substring(query.indexOf("Buy") + 4, query.indexOf("shares") - 1));
        int price = Integer.parseInt(query.substring(query.indexOf("$") + 1, query.indexOf("each") - 1));
        shareQueue.offer(share);
        priceQueue.offer(price);
        System.out.println("Bought " + share + " shares at $" + price + " each");
        System.out.println("\nQueue for shares: " + shareQueue.toString());
        System.out.println("Queue for prices: " + priceQueue.toString());
    }

    static int sell(Queue<Integer> shareQueue, Queue<Integer> priceQueue, String query){
        int share = Integer.parseInt(query.substring(query.indexOf("Sell") + 5, query.indexOf("shares") - 1));
        int price = Integer.parseInt(query.substring(query.indexOf("$") + 1, query.indexOf("each") - 1));
        int profit = 0;
        while (share > 0){
            int sharesHave = shareQueue.poll();
            if (sharesHave > share){
                int priceHave = priceQueue.peek();
                shareQueue.offer(sharesHave - share);
                profit += (price - priceHave) * share;
                share = 0;
            } else if (share > sharesHave && shareQueue.isEmpty()){
                int priceHave = priceQueue.poll();
                profit += (price - priceHave) * sharesHave;
                share = 0;
            } else {
                int priceHave = priceQueue.poll();
                profit += (price - priceHave) * sharesHave;
                share -= sharesHave;
            }
        }
        System.out.println("Profit: $" + profit);
        System.out.println("\nQueue for shares: " + shareQueue.toString());
        System.out.println("Queue for prices: " + priceQueue.toString());
        return profit;
    }
}


/*
 Create two priority queues with the following elements: {"George", "Jim", "John",
"Blake", "Kevin", "Michael"} and {"George", "Katie", "Kevin", "Michelle", "Ryan"}.
Find their union, difference, and intersection.
 */
import java.util.PriorityQueue;
public class L7bQ2 {
    public static void main(String[] args) {
        // Create two priority queues with the following elements
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("George");
        queue1.offer("Jim");
        queue1.offer("John");
        queue1.offer("Blake");
        queue1.offer("Kevin");
        queue1.offer("Michael");

        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.offer("George");
        queue2.offer("Katie");
        queue2.offer("Kevin");
        queue2.offer("Michelle");
        queue2.offer("Ryan");

        // Find their union
        System.out.println("Union: ");
        PriorityQueue<String> union = new PriorityQueue<>(queue1);
        for(String s: queue2) {
            if (!union.contains(s))
                union.add(s);
        }

        System.out.println(union);

        // Find their difference
        System.out.println("Difference: ");
        PriorityQueue<String> difference = new PriorityQueue<>(queue1);
        difference.removeAll(queue2);
        System.out.println(difference);

        // Find their intersection
        System.out.println("Intersection: ");
        PriorityQueue<String> intersection = new PriorityQueue<>(queue1);
        intersection.retainAll(queue2);
        System.out.println(intersection);
    }
}

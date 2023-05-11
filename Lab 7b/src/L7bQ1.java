/*
Given an integer array which consists of {4, 8, 1, 2, 9, 6, 3, 7}. Insert these integers into a
priority queue using its ADT. Then, perform the following operations to the priority
queue:

 toString() - Display all the elements inside this priority queue.
 poll() – retrieve and remove the first element in this priority queue.
 add() – add new element 5 into the priority queue
 toArray() – convert the priority queue into an array and display.
 peek() – retrieve the first element in the priority queue.
 contains() – check if the priority queue consists of element “1”.
 size() – get the current size of the priority queue.
 isEmpty() – display while removing the elements in the queue until it is empty.
 Sort the priority queue in reversing order.
 */
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class L7bQ1 {
    public static void main(String[] args) {
        // Create a priority queue and add the given elements
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        queue.offer(4);
        queue.offer(8);
        queue.offer(1);
        queue.offer(2);
        queue.offer(9);
        queue.offer(6);
        queue.offer(3);
        queue.offer(7);


        // Display all the elements inside this priority queue
        System.out.println("toString() - Display all the elements inside this priority queue.");
        System.out.println(queue.toString());

        // Retrieve and remove the first element in this priority queue
        System.out.println("poll() - Retrieve and remove the first element in this priority queue.");
        System.out.println(queue.poll());

        // Add new element 5 into the priority queue
        System.out.println("add(5) - Add new element 5 into the priority queue.");
        queue.add(5);

        // Convert the priority queue into an array and display
        System.out.println("toArray() - Convert the priority queue into an array and display.");
        Integer[] arr = queue.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));

        // Retrieve the first element in the priority queue
        System.out.println("peek() - Retrieve the first element in the priority queue.");
        System.out.println(queue.peek());

        // Check if the priority queue consists of element “1”
        System.out.println("contains(1) - Check if the priority queue consists of element “1”.");
        System.out.println(queue.contains(1));

        // Get the current size of the priority queue
        System.out.println("size() - Get the current size of the priority queue.");
        System.out.println(queue.size());

        // Display while removing the elements in the queue until it is empty
        System.out.println("isEmpty() - Display while removing the elements in the queue until it is empty.");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Sort the priority queue in reversing order
        PriorityQueue<Integer> reversedQueue = new PriorityQueue<>(Collections.reverseOrder());
        reversedQueue.addAll(Arrays.asList(arr));
        System.out.println("Reversed priority queue: " + reversedQueue.toString());
    }
}


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T7Q3 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner keyIn = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            if (keyIn.nextBoolean())
                System.out.print(i + " ");
            else
                q.offer(i);
        }
        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
        System.out.println();
    }
}

//a) What is the output for the following code input sequence? (true false false true true)
//Answer: 1 4 5 2 3

/*
// Not possible to have output 1 3 5 4 2
//
// 1 is printed
// 2 is not printed but instead enqueued
// 3 is printed
// 4 is not printed but instead enqueued
// 5 is printed
//
// Queue = [2, 4]
// 2 and 4 will be printed.
// Hence, it is impossible to print 4 2.
 */


/*
Question c)  Give at least three input sequences that produce the output: 1 2 3 4 5
Answer: true true true true true
        true true true true false
        false false false false false
 */
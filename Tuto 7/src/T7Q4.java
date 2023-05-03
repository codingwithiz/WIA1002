import java.util.Queue;
import java.util.LinkedList;

public class T7Q4 {
    public static void main(String[]args){
        Queue<Integer> x = new LinkedList<>();
        x.offer(14);
        x.offer(3);
        x.offer(5);
        // x = [14, 3, 5]
        Object Y = x.poll();
        x.offer(7);
        x.offer(9);
        // x = [3, 5, 7, 9]

        Y = x.poll();
        x.offer(2);
        x.offer(4);
        // x = [5, 7, 9, 2, 4]

        x.peek(); //a) 5

        Y = x.poll();
        // x = [7, 9, 2, 4]
        x.offer(10);
        // x = [7, 9, 2, 4, 10]
        x.peek(); //b) 7

        Y = x.poll();                   // c) 7
        // X = [9,2,4,10], Y = 7

        x.peek(); //d) 9

    }
}

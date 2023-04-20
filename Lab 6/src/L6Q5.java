//The Tower of Hanoi is a mathematical game or puzzle. It consists of three rods, and
//a number of disks of different sizes which can slide onto any rod. The puzzle starts
//with the disks in a neat stack in ascending order of size on one rod, the smallest at
//the top, thus making a conical shape. The objective of the puzzle is to move the
//entire stack to another rod, obeying the following rules:
//i) Only one disk may be moved at a time.
//ii) Each move consists of taking the upper disk from one of the rods and sliding it
//onto another rod, on top of the other disks that may already be present on that rod.
//iii) No disk may be placed on top of a smaller disk.
//You are required to write the source code using Java syntax to solve Tower of Hanoi
//Problem using stacks data structure.
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class L6Q5 {
    private static final Stack<Integer>[] rods = new Stack[3];
    private static int numberOfDisks;
    private static final int DELAY = 250;
    private static final boolean AI = true;
    private static final boolean ITERATIVE = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        numberOfDisks = scanner.nextInt();
        if (numberOfDisks <= 0) throw new IllegalArgumentException();

        // Initialise the game
        for (int i = 0; i < 3; i++)
            rods[i] = new Stack<>();
        for (int i = numberOfDisks; i > 0; i--)
            rods[0].push(i);

        if (AI) {
            try {
                if (ITERATIVE) {
                    int[][] odd = {{0,2},{0,1},{1,2}};
                    int[][] even = {{0,1},{0,2},{1,2}};
                    int[][] moves = (numberOfDisks % 2 == 1 ? odd : even);

                    while (!hasWon()) {
                        for (int[] move : moves) {
                            iterative(move[0], move[1]);
                            if (hasWon()) break;
                        }
                    }
                } else recursive();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            while (!hasWon()) {
                display();
                System.out.print("Enter your move: ");
                int from = scanner.nextInt()-1;
                int to = scanner.nextInt()-1;
                if (!isLegalMove(from, to)) {
                    System.out.println("Invalid move.");
                    continue;
                }
                rods[to].push(rods[from].pop());
                System.out.println();
            }
        }
        display();
        System.out.println("You Won!!!");
    }

    private static boolean isLegalMove(int from, int to) {
        if (from < 0 || from > 2 || to < 0 || to > 2) return false;
        if (rods[from].isEmpty()) return false;
        if (!rods[to].isEmpty() && rods[from].peek() > rods[to].peek()) return false;
        return true;
    }

    private static void iterative(int a, int b) throws InterruptedException {
        if (!isLegalMove(a, b) ) {
            if (isLegalMove(b, a))
                iterative(b, a);
            return;
        }
        display();
        rods[b].push(rods[a].pop());
        System.out.println((a+1) + " -> " + (b+1));
        Thread.sleep(DELAY);
    }
    private static void recursive() throws InterruptedException {
        recursive(numberOfDisks, 0, 1, 2);
    }
    private static void recursive(int n, int source, int intermediate, int target) throws InterruptedException {
        if (n == 0) return;
        recursive(n-1, source, target, intermediate);

        display();
        rods[target].push(rods[source].pop());
        System.out.println((source+1) + " -> " + (target+1));
        Thread.sleep(DELAY);

        recursive(n-1, intermediate, source, target);
    }

    private static boolean hasWon() {
        return rods[2].size() == numberOfDisks;
    }
    private static void display() {
        Iterator<Integer>[] iterators = new Iterator[3];
        for (int i = 0; i < 3; i++)
            iterators[i] = rods[i].iterator();

        StringBuilder s = new StringBuilder();
        for (int row = 0; row <= numberOfDisks; row++) {
            StringBuilder line = new StringBuilder();
            for (Iterator<Integer> iterator : iterators)
                if (iterator.hasNext())
                    line.append(diskImage(iterator.next())).append(" ");
                else line.append(diskImage()).append(" ");
            line.append('\n');
            s.insert(0, line);
        }
        System.out.print(s);
    }

    private static String diskImage() {
        int space = numberOfDisks - 1;
        return " ".repeat(space) + "|" + " ".repeat(space);
    }

    private static String diskImage(int size) {
        int space = numberOfDisks - size;
        size = 2*size - 1;
        return " ".repeat(space) + "=".repeat(size) + " ".repeat(space);
    }
}
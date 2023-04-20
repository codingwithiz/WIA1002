public class L6Q3 {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i <= 10; i += 2)
            stack.push(i);
        System.out.println("Sum: " + sum(stack));
    }

    public static int sum(MyStack<Integer> S) {
        int sum = 0;
        while (!S.isEmpty())
            sum += S.pop();
        return sum;
    }
}

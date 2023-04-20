import java.util.Scanner;

public class L6Q2 {
    public static void main(String[]args){
        TestIntMyStack.main(args);
    }
}

class TestIntMyStack{
    public static void main(String[]args){
        MyStack<Integer> stack = new MyStack<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer value: ");
        int value = sc.nextInt();

        for(int i = 1 ; i<= value ; i++){
            stack.push(i);
        }
        System.out.println(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop() + "");
        }
        System.out.println();

        // Answers:
        // Output: n = user entered value n-1 n-2 ... 2 1
        // Order: Descending order
        // Reason: Stack is a last in, first out data structure.
        //         Therefore, the larger numbers are popped first as they are pushed later than the smaller numbers.

    }
}

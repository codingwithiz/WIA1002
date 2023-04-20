import java.util.ArrayList;

public class L6Q1 {
    public static void main(String[] args) {
        TestMyStack.main(args);
    }
}

class MyStack<E>{
    ArrayList<E> list = new ArrayList<E>();
    public void push(E o){
        list.add(o);
    }

    public E pop(){
        E o = list.get(list.size()-1);
        list.remove(list.size()-1);
        return o;
    }

    public E peek(){
        return list.get(list.size()-1);
    }

    public int getSize(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    @Override
    public String toString(){
        return "stack: " + list.toString();
    }

    public boolean search(E o){
        return list.contains(o);
    }
}

class TestMyStack{
    public static void main(String[]args){
        MyStack<Character> stack = new MyStack<Character>();
        for(char c = 'a' ; c<= 'c' ; c++){
            stack.push(c);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println("'b' is in the stack? " + stack.search('b'));
        System.out.println("'d' is in the stack? " + stack.search('d'));
        System.out.println();

        MyStack<Integer> stack2 = new MyStack<Integer>();
        for(int i = 1 ; i<= 3 ; i++){
            stack2.push(i);
        }
        System.out.println(stack2);
        System.out.println("6 is in the stack? " + stack2.search(6));
    }
}
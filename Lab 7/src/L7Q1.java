import java.util.Collections;
import java.util.LinkedList;

public class L7Q1 {
    public static void main(String[]args){
        String[] fruitQ = {"Durian" , "Blueberry"};
        MyQueue <String> fruit = new MyQueue(fruitQ);
        fruit.enqueue("Apple");
        fruit.enqueue("Orange");
        fruit.enqueue("Grapes");
        fruit.enqueue("Cherry");
        System.out.println(fruit);
        System.out.println("Top item: " + fruit.peek());
        System.out.println("Queue size: " + fruit.getSize());
        System.out.println("Delete durian:  " + fruit.dequeue());
        System.out.println("Get item in index position of 2: " + fruit.getElement(2));
        System.out.println("Check Cherry: " + fruit.contains("Cherry"));
        System.out.println("Check Durian: " + fruit.contains("Durian"));
        System.out.println("Check empty: " + fruit.isEmpty());
    }
}

class MyQueue<E>{
    private LinkedList<E> list;

    public MyQueue(E[]fruitQ){
        this();
        Collections.addAll(list, fruitQ);
    }

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void enqueue(E e){
        list.add(e);
    }

    public E dequeue(){
        return list.removeFirst();
    }

    public E getElement(int index){
        return list.get(index);
    }
    public E peek(){
        return list.getFirst();
    }

    public int getSize(){
        return list.size();
    }

    public boolean contains(E e){
        return list.contains(e);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}


/*
Provide and explain three operations / functions of Linked List based Queue that you can add
to the GenericQueue class, other than those discussed in the lecture (i.e., enqueue, dequeue
and getSize – from Slide 10 in the lecture slide).
 */
import java.util.LinkedList;

public class T7Q5 {

    class Queue<E> {
        LinkedList<E> list = new LinkedList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public E peek() {
            return list.getFirst();
        }

        public boolean contains(E e) {
            return list.contains(e);
        }
    }
}

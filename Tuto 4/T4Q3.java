public class T4Q3 {
    //a removeLast
    //b
    class LinkedList<E>{
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public void removeLast(){
            if(head == null){
                return;
            }
            if(head == tail){
                head = tail = null;
                return;
            }
            Node<E> current = head;
            while(current.next != tail){
                current = current.next;
            }
            tail = current;
            tail.next = null;
            size--;
        }
    }

    class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
}

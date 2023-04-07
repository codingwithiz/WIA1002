public class T4Q2 {
    //a contains
    //b
    class LinkedList<E>{
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public boolean contains(E item){
            Node<E> current = head;
            while(current != null){
                if(current.data.equals(item)){
                    return true;
                }
                current = current.next;
            }
            return false;
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

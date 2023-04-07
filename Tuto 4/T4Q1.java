public class T4Q1{
    public static void main(String[] args){
        LinkedList.main(args);
    }
}

class LinkedList<E>{
    private Node<E> head = null;
    private Node<E> tail = null;
   int size = 0;

    public static class Node<E>{
        public E item;
        public Node<E>next;

        public Node(E item){
            this.item = item;
        }
    }

    public static void main(String[]args){
        //a)
        LinkedList<Character> list = new LinkedList<>();
        Node<Character> node1 = new Node<>('a');
        Node<Character> node2 = new Node<>('z');
        list.head = node1;
        list.tail = node2;

        //c
        node1.next = node2;

        //h
        list.addLast('c');
        list.add(2,'d');
        list.remove(1);
        list.printList();
    }

    public void addFirst(E item){
        Node<E> firstNode = new Node<>(item);
        firstNode.next = head;
        head = firstNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void addLast(E item){
        Node<E> newTail = new Node<>(item);
        if (tail == null) {
            head = tail = newTail;
            return;
        }
        tail.next = newTail;
        tail = newTail;
        size++;
    }

    public void add(int index, E item){
        if(index == 0){
            addFirst(item);
            return;
        }
        Node<E> current = head;
        for(int i = 1; i < index && current != null; i++){
            current = current.next;
        }
        if(current == null){
            return;
        }
        Node<E> temp = current.next;
        current.next = new Node<>(item);
        (current.next).next = temp;
        size++;
    }

    public void removeFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

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

    public void remove(int index){
        if(index < 0 || index >= size){
            return;
        }
        if(index == 0){
            removeFirst();
            return;
        }
        Node<E> current = head;
        for(int i = 1; i < index; i++){
            current = current.next;
        }
        Node<E> temp = current.next;
        current.next = temp.next;
        if(current.next == null){
            tail = current;
        }
        size--;
    }

    public void printList () {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class L4Q1 {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        //a
        list.addLast('a');
        list.addLast('b');
        list.addLast('c');
        list.addLast('d');
        list.addLast('e');
        //b
        list.print();
        //c
        list.reverse();
        //d
        System.out.println(list.size);
        //e
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        //f
        System.out.println("Deleted: " + list.remove(2));
        //g
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        //h
        System.out.println(list.contains('c'));
        //i
        list.set(0,'j');
        list.set(1,'a');
        list.set(2,'v');
        list.set(3,'a');
        list.print();
        System.out.println(list.getMiddleValue());
    }
}

class Node<E>{
    public E data;
    public Node<E> next;
    public Node(E data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList<E>{
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E item){
        Node<E> temp = head;
        head = new Node<>(item);
        head.next = temp;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void addLast(E item){
        if(tail == null){
            head = tail = new Node<>(item);
        }else{
            tail.next = new Node<>(item);
            tail = tail.next;
        }
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

    public E removeFirst(){
        if(head == null) {
            return null;
        }
        E temp = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return temp;
    }

    public E removeLast(){
        if(head == null){
            return null;
        }
        E item = tail.data;
        if(head == tail){
            head = tail = null;
            return item;
        }
        Node<E> current = head;
        while(current.next != tail){
            current = current.next;
        }
        tail = current;
        tail.next = null;
        size--;
        return item;
    }

    public E remove(int index){
        if(index <0 || index>= size){
            return null;
        }
        if(index ==0){
            return removeFirst();
        }
        Node<E> current = head;
        for(int i = 1; i < index; i++){
            current = current.next;
        }
        E item = current.next.data;
        current.next = current.next.next;
        if(current.next == null){
            tail = current;
        }
        size--;
        return item;
    }

    public boolean contains(E e){
        Node<E> current = head;
        while(current != null){
            if(current.data.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index){
        Node <E> current = head;
        for(int i = 0 ; i<size ; i++){
            if(i == index){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public E getFirst(){
        return head.data;
    }

    public E getLast(){
        return tail.data;
    }

    public int indexOf (E e){
        Node<E> current = head;
        for(int i = 0 ; i<size ; i++){
            if(current.data.equals(e)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf (E e){
        Node<E> current = head;
        int index = -1;
        for(int i = 0 ; i<size ; i++){
            if(current.data.equals(e)){
                index = i;
            }
            current = current.next;
        }
        return index;
    }

    public E set(int index, E e){
        Node<E> current = head;
        for(int i = 0 ; i<size ; i++){
            if(i == index){
                E temp = current.data;
                current.data = e;
                return temp;
            }
            current = current.next;
        }
        return null;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }

    public void print(){
        Node<E> current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse(){
        String s = "";
        Node<E> current = head;
        while(current != null){
            s = current.data + " " + s;
            current = current.next;
        }
        System.out.println(s);
    }

    public E getMiddleValue(){
        Node<E> current = head;
        for(int i = 0 ; i<size/2 ; i++){
            current = current.next;
        }
        return current.data;
    }
}
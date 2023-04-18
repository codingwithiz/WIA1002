package L5Q3;

public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e, head, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e, null, tail);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node<E> newNode = new Node<E>(e, temp, temp.prev);
            temp.prev.next = newNode;
            temp.prev = newNode;
            size++;
        }
    }

    public void iterateBackward(){
        Node<E> temp = tail;
        while(temp != null){
            System.out.print(temp.element + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void iterateForward(){
        Node<E> temp = head;
        while(temp != null){
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public E removeFirst(){
        E e = null;
        if(head == null){
            return e;
        }else if(head == tail){
            e = head.element;
            head = tail = null;
        }else{
            e = head.element;
            head = head.next;
            head.prev = null;
        }
        size--;
        return e;
    }

    public E removeLast(){
        E e = null;
        if(head == null){
            return e;
        }else if(head == tail){
            e = head.element;
            head = tail = null;
        }else{
            e = tail.element;
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return e;
    }

    public E remove(E e){
        Node<E> temp = head;
        while(temp != null){
            if(temp.element.equals(e)){
                if(temp == head){
                    return removeFirst();
                }else if(temp == tail){
                    return removeLast();
                }else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                    return temp.element;
                }
            }
            temp = temp.next;
        }
        return e;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
}

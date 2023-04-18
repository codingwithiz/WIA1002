package SList;

public class SList <E> {
    SNode<E> head;
    SNode<E> tail;
    int size;

    public SList() {
        head = null;
        tail = null;
        size = 0;
    }

    //Q1
    public void appendEnd(E e) {
        SNode<E> newNode = new SNode<E>(e, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E removeInitial() {
        if (head == null) {
            return null;
        }
        E temp = head.element;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return temp;
    }

    public boolean contains(E e) {
        SNode<E> temp = head;
        while (temp != null) {
            if (temp.element.equals(e)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void display() {
        SNode<E> temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Q2
    public void add(E e) {
        SNode<E> newNode = new SNode<E>(e, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void removeElement(E e) {
        SNode<E> temp = head;
        while (temp != null) {
            if (temp.element.equals(e)) {
                temp.element = temp.next.element;
                temp.next = temp.next.next;
                size--;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    public void printList() {
        SNode<E> temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    //public boolean contains(E e){} done in Q1
    public void replace(E e, E newE){
        SNode<E> temp = head;
        while(temp != null){
            if(temp.element.equals(e)){
                temp.element = newE;
                break;
            }
            temp = temp.next;
        }
    }



}

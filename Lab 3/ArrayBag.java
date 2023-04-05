

public class ArrayBag <T> implements BagInterface <T>{
    private T[]bag = (T[]) new Object [DEFAULT_CAPACITY];
    private int numOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    @Override
    public int getCurrentSize() {
        return numOfEntries;
    }

    @Override
    public boolean isFull() {
        return numOfEntries == 25;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull()){
            return false;
        }
        else{
            bag[numOfEntries] = newEntry;
            numOfEntries++;
            return true;
        }
    }

    @Override
    public T remove() {
        if(isEmpty()){
            return null;
        }
        else{
            T temp = bag[numOfEntries-1];
            bag[numOfEntries-1] = null;
            numOfEntries--;
            return temp;
        }
    }

    @Override
    public boolean remove(T anEntry) {
        if(isEmpty()) {
            return false;
        }
        else{
            for(int i = 0 ; i<numOfEntries ; i++){
                if(bag[i].equals(anEntry)){
                    bag[i] = bag[numOfEntries-1];
                    bag[numOfEntries-1] = null;
                    numOfEntries--;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void clear() {
        for(int i = 0 ; i<numOfEntries ; i++){
            bag[i] = null;
        }
        numOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for(int i = 0 ; i<numOfEntries ; i++){
            if(bag[i].equals(anEntry)){
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        for(int i = 0 ; i<numOfEntries ; i++){
            if(bag[i].equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] temp = (T[]) new Object[numOfEntries];
        for(int i = 0 ; i<numOfEntries ; i++){
            temp[i] = bag[i];
        }
        return temp;
    }

    public BagInterface <T> union(BagInterface <? extends T> bag2){
        BagInterface <T> temp = new ArrayBag<>();
        T[] temp1 = this.toArray();
        T[] temp2 = bag2.toArray();
        for(int i = 0 ; i<temp1.length ; i++){
            temp.add(temp1[i]);
        }
        for(int i = 0 ; i<temp2.length ; i++){
            temp.add(temp2[i]);
        }
        return temp;
    }

    public BagInterface<T> intersection(BagInterface<? extends T> bag2){
        BagInterface <T> temp = new ArrayBag<>();
        T[] temp1 = this.toArray();
        T[] temp2 = bag2.toArray();
        for(int i = 0 ; i<temp1.length ; i++){
            for(int j = 0 ; j<temp2.length ; j++){
                if(temp1[i].equals(temp2[j])){
                    temp.add(temp1[i]);
                }
            }
        }
        return temp;
    }

    public BagInterface<T> difference(BagInterface<? extends T> bag2){
        BagInterface <T> temp = new ArrayBag<>();
        T[] temp1 = this.toArray();
        T[] temp2 = bag2.toArray();
        for(int i = 0 ; i<temp1.length ; i++){
            temp.add(temp1[i]);
        }
        for(int i = 0 ; i<temp2.length ; i++){
            temp.remove(temp2[i]);
        }
        return temp;
    }
}
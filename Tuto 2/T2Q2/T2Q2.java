package T2Q2;

public class T2Q2 {
    public static void main(String[]args){
        myArray.main(args);
    }
}

class myArray<T> {
    public static void main(String [] args){
        Integer [] number = {1,2,3,4,5};
        String [] names = {"Jane" , "Tom" , "Peter"};
        Character [] alphabet = {'a' , 'b' , 'c'};

        listAll(number);
        listAll(names);
        listAll(alphabet);
    }

    public static  <T> void listAll(T[] array){
        for (T t : array){
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
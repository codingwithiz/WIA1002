package Lab_2;

public class L2Q4 {
    public static void main(String[]args){
        Integer[] intArray = {5 , 3 , 7 , 1 , 4 , 9 , 8 , 2};
        String[] strArray = {"red" , "blue" , "orange" , "tan"};
        System.out.println(minMax(intArray));
        System.out.println(minMax(strArray));
    }

    public static <T extends Comparable<T>> String minMax(T[] array){
        T min = array[0];
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(min) < 0){
                min = array[i];
            }
            if (array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return "Min: " + min + " Max: " + max;
    }
}

package Lab_2;

public class L2Q2 {
    public static void main(String[]args){
        CompareMax cm = new CompareMax();
        System.out.println(cm.maximum(10, 20, 30));
        System.out.println(cm.maximum(false, false, true));
        System.out.println(cm.maximum("JoJo", "Bizarre", "Adventure"));
    }
}

class CompareMax{
    public static <E extends Comparable<E>> E maximum(E max1 , E max2 , E max3){
        E max = max1;
        if(max2.compareTo(max) > 0){
            max = max2;
        }
        if(max3.compareTo(max) > 0){
            max = max3;
        }
        return max;
    }
}

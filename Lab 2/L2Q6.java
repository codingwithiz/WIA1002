package Lab_2;

public class L2Q6 {
    public static void main(String[]args){
        Integer[][] intArray = {{4,5,6},{1,2,3}};
        System.out.println(MinMaxTwoArray.min(intArray));
        System.out.println(MinMaxTwoArray.max(intArray));

    }
}

class MinMaxTwoArray{
    public static <E extends Comparable<E>> E min(E[][]list){
        E min = list[0][0];
        for(int i = 0; i<list.length ; i++){
            for(int j = 0; j<list[i].length ; j++){
                if(list[i][j].compareTo(min) < 0){
                    min = list[i][j];
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][]list) {
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(max) > 0) {
                    max = list[i][j];
                }
            }
        }
        return max;
        }
    }
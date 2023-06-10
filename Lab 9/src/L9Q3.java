/*
Write a recursive method called exponent(x,y) to perform exponentiation return xy
, assuming
y >= 0. Example:
exponent(10,3) → will produce an output of 1000
 */

public class L9Q3 {
    public static void main(String[]args){
        System.out.println(exponent(10,3));
    }

    public static int exponent(int x, int y){
        if(y == 0){
            return 1;
        }
        else{
            return x * exponent(x, y-1);
        }
    }
}

public class T9Q5 {
    public static void main(String[]args){
        System.out.println(printDigit(4567));
    }

    public static String printDigit(int n){
        if(n < 10){
            return Integer.toString(n);
        }else{
            return printDigit(n/10) + " " + n % 10;
        }
    }
}
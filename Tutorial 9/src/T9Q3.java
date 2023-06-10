public class T9Q3 {
    public static void main(String[]args){
        System.out.println(Inverse("String"));
    }

    public static String Inverse(String s){
        if(s.length() ==1){
            return s;
        }
        else{
            return Inverse(s.substring(1)) + s.charAt(0);
        }
    }
}

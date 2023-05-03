import java.util.LinkedList;
import java.util.Queue;

public class L7Q2 {
    public static void main(String[]args){
        System.out.println("Is madam a palindrome? " + isPalindrome("madam"));
        System.out.println("Is apple a palindrome? " + isPalindrome("apple"));
        System.out.println("Is racecar a palindrome? " + isPalindrome("racecar"));
    }

    private static boolean isPalindrome(String s){
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != queue.poll()){
                return false;
            }
        }
        return true;

    }
}

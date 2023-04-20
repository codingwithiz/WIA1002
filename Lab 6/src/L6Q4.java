public class L6Q4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("level"));
    }

    public static boolean isPalindrome(String s){
        MyStack<Character> stack = new MyStack<>();
        for(int i = 0 ; i < s.length() ; i++){
            stack.push(s.charAt(i));
        }
        String reverse = "";
        while(!stack.isEmpty()){
            reverse += stack.pop();
        }
        return s.equals(reverse);
    }
}

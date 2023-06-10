/*
Write a recursive method called permuteString() that will find and print all the possibilities to
arrange the letters of a given word. Example:
Input String : “ABC”
Output Permutation :
ABC
ACB
BAC
BCA
CAB
CBA
 */

import java.util.ArrayList;
import java.util.List;

public class L9Q2 {
    public static void main(String[]args){
        System.out.println(permuteString("ABC"));
    }

    public static List<String> permuteString(String word) {
        if(word.length() == 0){
            return List.of("");
        }
        char firstChar = word.charAt(0);
        List<String> permutations = permuteString(word.substring(1));
        List<String> list = new ArrayList<>();
        for(String permutation: permutations){
            for(int i = 0; i<word.length() ; i++){
                list.add(insert(permutation, firstChar, i));
            }
        }
        return list;
    }

    public static String insert(String s, char c , int i){
        return s.substring(0,i) + c + s.substring(i);
    }
}

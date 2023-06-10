/*
Create a recursive function that accepts a String parameter, and substitute any of the
lowercase “a” (no applicable for uppercase "A") found with “i” char. Example:
substituteAI ("flabbergasted ") → "flibbergisted "
substituteAI ("Astronaut ") → " Astroniut"
 */

public class L9Q1 {
    public static void main(String[]args){
        System.out.println(substituteAI("flabbergasted"));
    }

    public static String substituteAI(String word){
        if(word.length() == 0){
            return word;
        }
        else if(word.charAt(0) == 'a'){
            return "i" + substituteAI(word.substring(1));
        }
        else{
            return word.charAt(0) + substituteAI(word.substring(1));
        }

    }
}

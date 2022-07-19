import java.util.Stack;

public class Solution {


    //create stack to store the corresponding closed brackets if encountered a open bracket.
    //ignore non-bracket string
    //if encountered closed bracket, pop from stack to see if they match.
    //what should i return if string is empty or there is no brackets at all? --> True (assume it is true because there is no need to check for validation)

    public static boolean validParen(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c != '}' || c != ']' || c != ')') {
                continue;
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;

                }

            }

        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String test1 = "{food}"; //this should return true
        String test2 = "{pets]"; // this should return false;
        String test3 = "hello"; //this should return true;
        String test4 = "[({})]"; //this should return true;
        System.out.println(validParen(test1));
        System.out.println(validParen(test2));
        System.out.println(validParen(test3));
        System.out.println(validParen(test4));


    }
}


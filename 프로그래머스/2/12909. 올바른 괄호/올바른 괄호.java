import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        
        if(String.valueOf(s.charAt(0)).equals(")"))
            return false;

        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == ')'){
                stack.pop();
            }
            else{
                stack.push('(');
            }
        }

        return (stack.isEmpty()) ? true : false;
    }
}
import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                
                return false;
            } else stack.push('(');
        }
        
        if(stack.size() > 0) return false;
        
        return true;
    }
}

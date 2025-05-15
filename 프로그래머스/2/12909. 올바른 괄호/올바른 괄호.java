import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (answer) {
            if (stack.size() > 0) answer = false;
        }

        return answer;
    }
}
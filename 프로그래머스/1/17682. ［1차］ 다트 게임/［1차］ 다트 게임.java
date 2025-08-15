import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i<dartResult.length(); i++) {
            char now = dartResult.charAt(i);
            char now2 = dartResult.charAt(++i);
            int score = 0;
            
            if (now2 == '0') {
                score = 10;
                now2 = dartResult.charAt(++i);
            } else {
                score = Integer.parseInt(String.valueOf(now));
            }
            
            switch(now2) {
                case 'S':
                    break;
                case 'D':
                    score = (int) Math.pow(score, 2);
                    break;
                case 'T':
                    score = (int) Math.pow(score, 3);
                    break;
            }
            char now3;
            if (i < dartResult.length()-1) {
                if (dartResult.charAt(i+1) == '#' || dartResult.charAt(i+1) == '*') {
                    now3 = dartResult.charAt(++i);
                 
                    switch(now3) {
                        case '*':
                            if(!stack.isEmpty()) {
                                int pre = stack.pop() * 2;
                                stack.push(pre);
                            }
                            score *= 2;
                            break;
                        case '#':
                            score *= (-1);
                            break;
                    }
                }
            }
            stack.push(score);
        }
        int size = stack.size();
        for (int i = 0; i<size; i++) {
            answer += stack.pop();
        }
        return answer;
    }
}
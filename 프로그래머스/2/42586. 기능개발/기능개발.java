import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = progresses.length-1; i>=0; i--) {
            stack.push(i);
        }
        int day = 1;
        while(true) {
            int end = 0;
            if (stack.isEmpty()) {
                break;
            }
            while(!stack.isEmpty()) {
                int now = stack.peek();
                int percent = progresses[now] + speeds[now]*day;
                
                if (percent >= 100) {
                    end++;
                    stack.pop();
                } else {
                    break;
                }
            }
            if (end > 0) {
                list.add(end);
            }
            day++;
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
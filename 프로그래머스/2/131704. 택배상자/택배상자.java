import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> container = new Stack<>();
        
        for (int i = 1; i<=order.length; i++) {
            container.push(i);
            
            while(!container.isEmpty()) {
                if (container.peek() == order[answer]) {
                    answer++;
                    container.pop();
                } else {
                    break;
                }
            }
        }
        
       
        return answer;
    }
}
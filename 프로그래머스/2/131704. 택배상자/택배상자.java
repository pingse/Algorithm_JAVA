import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> container1 = new Stack<>();
        Stack<Integer> container2 = new Stack<>();
        
        for (int i = order.length; i>=1; i--) {
            container1.push(i);
        }
        
        while(true) {
            if (container1.size() == 0 && container2.size() == 0) {
                break;
            }
            
            if (container1.size() > 0 && container1.peek() == order[answer]) {
                answer++;
                container1.pop();
            } else if (container2.size() > 0 && container2.peek() == order[answer]) {
                answer++;
                container2.pop();
            } else if (container1.size() == 0 && container2.size() > 0){
                if (container2.peek() == order[answer]) {
                    answer++;
                }
                container2.pop();
            } else if (container2.size() == 0 && container1.peek() != order[answer]) {
                container2.push(container1.pop());
            } else {
                if (container1.size() > 0 && order[answer] < container1.peek()) {
                    if (container2.peek() == order[answer]) {
                        answer++;
                        container2.pop();
                    } else {
                        break;
                    }
                } else {
                    container2.push(container1.pop());
                }
            }
        }
        
        return answer;
    }
}
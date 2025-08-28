import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));
        
        for(int i = 0; i<goal.length; i++) {
            if (!queue1.isEmpty() && goal[i].equals(queue1.peek())) {
                queue1.poll();
            } else if(!queue2.isEmpty() && goal[i].equals(queue2.peek())) {
                queue2.poll();
            }  else {
                answer = "No";
                break;
            }
        }
        
        if (!answer.equals("No")) {
            answer = "Yes";
        }
        
        return answer;
    }
}
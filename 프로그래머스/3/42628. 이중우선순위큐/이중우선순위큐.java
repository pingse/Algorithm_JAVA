import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] s = operation.split(" ");
            
            switch(s[0]) {
                case "I":
                    maxQ.add(Integer.parseInt(s[1]));
                    minQ.add(Integer.parseInt(s[1]));
                    break;
                case "D":
                    if (s[1].equals("1")) {
                        minQ.remove(maxQ.poll());
                    } else {
                        maxQ.remove(minQ.poll());
                    }
                    break;
            }
        }
        
        answer[0] = !maxQ.isEmpty() ? maxQ.poll() : 0;
        answer[1] = !minQ.isEmpty() ? minQ.poll() : 0;
        
        return answer;
    }
}
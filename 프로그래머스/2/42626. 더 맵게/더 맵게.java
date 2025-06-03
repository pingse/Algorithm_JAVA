import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int mix = -1;
        while(pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            mix = first + (second * 2);
            pq.add(mix);
            answer++;
        }
        return answer;
    }
}
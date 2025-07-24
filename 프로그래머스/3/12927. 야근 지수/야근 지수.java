import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<works.length; i++) {
            pq.add(works[i]);
        }
        
        for (int i = 0; i<n; i++) {
            if (pq.size() == 0) {
                answer = 0;
                break;
            }
            
            int next = pq.poll();
            if (next - 1 > 0) {
                pq.add(next-1);
            }
        }
        
        for(int value : pq) {
            System.out.println(value);
            answer += value*value;
        }
        
        return answer;
    }
}
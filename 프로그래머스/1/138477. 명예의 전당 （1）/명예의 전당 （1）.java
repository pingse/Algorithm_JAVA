import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i<score.length; i++) {
            int n = score[i];
            
            if (pq.isEmpty()) {
                pq.add(n);
                answer[i] = n;
            } else {
                if (pq.size() >= k) {
                    int cur = pq.poll();
                    if (cur < n) {
                        pq.add(n);
                    } else {
                        pq.add(cur);
                    }
                } else {
                    pq.add(n);
                }
                
                answer[i] = pq.peek();
            }
        }
        
        return answer;
    }
}
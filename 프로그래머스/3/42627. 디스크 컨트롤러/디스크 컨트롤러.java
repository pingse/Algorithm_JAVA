import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        int second = 0;
        int jobCount = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while(jobCount < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= second) {
                pq.offer(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                second = jobs[idx][0];
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + second - temp[0];
                second += temp[1];
                jobCount++;
            }
        }
        answer /= jobs.length;
        return answer;
    }
}
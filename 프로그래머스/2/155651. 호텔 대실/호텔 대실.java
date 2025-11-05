import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for (String[] time : book_time) {
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            
            int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int e = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
            if (pq.isEmpty()) {
                pq.add(new int[]{s, e});
                answer++;
                continue;
            }
            
            int[] cur = pq.poll();
            
            if (s >= cur[1]) {
                pq.add(new int[]{s, e});
            } else {
                answer++;
                pq.add(new int[]{s, e});
                pq.add(cur);
            }
        }
        
        return answer;
    }
}
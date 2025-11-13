import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (getRemoveCount(mid, rocks, distance) > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
    
    int getRemoveCount(int v, int[] rocks, int distance) {
        int cur = 0;
        int end = distance;
        
        int count = 0;
        
        for (int i = 0; i<rocks.length; i++) {
            if (rocks[i] - cur < v) {
                count++;
                continue;
            }
            
            cur = rocks[i];
        }
        
        if (end - cur < v) count++;
        
        return count;
    }
}
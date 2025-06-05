import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        double s = Math.sqrt(n);
        if (s % 1 != 0) {
            answer = -1;
        } else {
            answer = (long) Math.pow((((int) s)+1), 2);
        }
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean b = true;
        for(int i = 2; i<= n; i++) {
            for (int j=2; j<= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                answer++;
            }
            b = true;
        }
        return answer;
    }
}
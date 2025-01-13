import java.util.*;

class Solution {
    public List solution(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(n);
        
        while (true) {
            if (n == 1) {
                break;
            }
            
            if (n % 2 == 0) {
                n /= 2;
                answer.add(n);
            } else {
                n = 3*n + 1;
                answer.add(n);
            }
        }
        
        
        return answer;
    }
}
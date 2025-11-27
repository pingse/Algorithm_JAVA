import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i<=n; i++) {
            if (count(i)) answer++;
        }
        return answer;
    }
    
    boolean count(int number) {
        int c = 0;
        for (int i = 1; i<=Math.sqrt(number); i++) {
            if (number % i == 0) {
                c++;
                if (number / i != i) {
                    c++;
                }
            }
        }
        
        return c >= 3 ? true : false;
    }
}
import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] count = new int[number+1];
        int c = 0;
        
        for (int i = 1; i<=number; i++) {
            c = 0;
            for (int j = 1; j<=(int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    c++;
                    if (j * j != i) {
                        c++;
                    }
                }
            }
            
            if (limit < c) {
                count[i] = power;
            } else {
                count[i] = c;
            }
        }
        for (int i = 1; i<=number; i++) {
            answer += count[i];
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public long solution(int[] arr) {
        long g;
        long answer = arr[0];
        
        for (int i = 1; i<arr.length; i++) {
            g = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / g;
        }
        
        
        return answer;
    }
    
    static long gcd(long a, long b) {
        while(b > 0) {
            long temp = b;
            a%=b;
            b = a;
            a = temp;
            
        }
        return a;
    }
}
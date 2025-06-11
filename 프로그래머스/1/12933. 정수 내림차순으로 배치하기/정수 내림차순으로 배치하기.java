import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        long[] arr = new long[s.length()];
        for (int i = 0; i<s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        Arrays.sort(arr);
        for (int i = s.length()-1; i>=0; i--) {
            answer *= 10;
            answer += arr[i];
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int len = number.length() - k;
        int s = 0;
        int max = 0;
        
        while (s < number.length() && sb.length() != len) {
            int ll = k + sb.length() + 1;
            max = 0;
            
            for (int i = s; i<ll; i++) {
                if (max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    s = i + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}
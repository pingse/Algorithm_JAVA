import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for (char now : s.toCharArray()) {
            int count = 0;
            for (int i = 0; i<index + count; i++) {
                if (++now > 'z') {
                    now = 'a';
                }
                
                if (skip.contains(String.valueOf(now))) {
                    count++;
                }
            }
            sb.append(String.valueOf(now));
        }
        return sb.toString();
    }
}
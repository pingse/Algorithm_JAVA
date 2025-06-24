import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = binary(s);
        
        return answer;
    }
    
    public int[] binary(String s) {
        int count = 0;
        int remove = 0;
        
        while(!s.equals("1")) {
            int before = s.length();
            s = s.replace("0", "");
            remove += (before - s.length());
            s = Integer.toBinaryString(s.length());
            count++;
        }
        
        return new int[]{count, remove};
    }
}
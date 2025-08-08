import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(String.valueOf(arr));
        answer = sb.reverse().toString();
        
        return answer;
    }
}
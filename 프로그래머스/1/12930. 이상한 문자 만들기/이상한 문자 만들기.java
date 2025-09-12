import java.util.*;

class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for(int i = 0; i<str.length; i++) {
            if (str[i] == ' ') {
                count = 0;
                continue;
            }
            if (count % 2 == 0) {
                str[i] = Character.toUpperCase(str[i]);
            } else {
                str[i] = Character.toLowerCase(str[i]);
            }
            count++;
        }
        String answer = String.valueOf(str);
        return answer;
    }
}
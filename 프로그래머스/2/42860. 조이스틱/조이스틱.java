import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        for (int i = 0; i<name.length(); i++) {
            int count = Math.min(26 - (name.charAt(i) - 'A'), name.charAt(i) - 'A');
            answer += count;
        }
        int cursor = name.length() - 1;
        for (int i = 0; i<name.length(); i++) {
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            cursor = Math.min(cursor, i + name.length() - next + Math.min(i, name.length() - next));
        }
        answer += cursor;
        return answer;
    }
}
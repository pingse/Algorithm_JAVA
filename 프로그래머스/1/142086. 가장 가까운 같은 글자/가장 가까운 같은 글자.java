import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(str[i])) {
                answer[i] = i - map.get(str[i]);
                map.put(str[i], i);
            } else {
                map.put(str[i], i);
                answer[i] = -1;
            }
        }
        return answer;
    }
}
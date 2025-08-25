import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> key = new HashMap<>();
        
        for (String s : keymap) {
            for (int i = 0; i<s.length(); i++) {
                char now = s.charAt(i);
                
                int v = key.getOrDefault(now, i+1);
                
                key.put(now, Math.min(v, i+1));
            }
        }
        
        for (int i = 0; i<answer.length; i++) {
            for (int j = 0; j<targets[i].length(); j++) {
                char now = targets[i].charAt(j);
                
                if (key.containsKey(now)) {
                    answer[i] += key.get(now);
                } else {
                    answer[i] = -1;
                    break;
                }
                
            }
        }
        return answer;
    }
}
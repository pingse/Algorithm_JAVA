import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (String p : participant) {
            if (map.containsKey(p)) {
                if (map.get(p) == 0) {
                    answer = p;
                    break;
                } else {
                    map.put(p, map.getOrDefault(p, 0) - 1);
                }
            } else {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}
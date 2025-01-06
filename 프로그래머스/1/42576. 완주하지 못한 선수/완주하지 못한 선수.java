import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i<completion.length; i++) {
            if (map.containsKey(completion[i])) {
                int a = map.get(completion[i]);
                map.put(completion[i], a+1);
            } else {
                map.put(completion[i], 1);
            }
        }
        
        for (int i = 0; i<participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                answer = participant[i];
                break;
            } else {
                int b = map.get(participant[i]);
                if (b != 0) {
                    map.put(participant[i], b-1);
                } else {
                    answer = participant[i];
                    break;
                }
            }
        }
        
        return answer;
    }
}
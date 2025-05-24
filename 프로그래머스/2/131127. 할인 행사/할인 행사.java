import java.util.*;
class Solution {
    static Map<String, Integer> wants = new HashMap<>();
    static Map<String, Integer> cur = new HashMap<>();
    static List<String> keys;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i<want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        keys = new ArrayList<>(wants.keySet());
        
        for (int i = 0; i<10; i++) {
            cur.put(discount[i], cur.getOrDefault(discount[i], 0) + 1);
        }
        
        if (validation()) answer++;
        
        for (int i = 10; i<discount.length; i++) {
            cur.put(discount[i-10], cur.getOrDefault(discount[i-10], 0) -1);
            cur.put(discount[i], cur.getOrDefault(discount[i], 0) + 1);
            if (validation()) answer++;
        }
        
        
        return answer;
    }
    
    static boolean validation() {
        
        for (String key : keys) {
            if (wants.get(key) > cur.getOrDefault(key, 0)) return false;
        }
        
        return true;
    }
}
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        long answer = counting(weights);
        
        return answer;
    }
    
    static long counting(int[] weights) {
        Map<Double, Integer> map = new HashMap<>();
        long ans = 0;
        
        for (int n : weights) {
            double a = n * 1.0;
            double b = (n * 2.0) / 3.0;
            double c = (n * 1.0) / 2.0;
            double d = (n * 3.0) / 4.0;
            
            if (map.containsKey(a)) ans += map.get(a);
            if (map.containsKey(b)) ans += map.get(b);
            if (map.containsKey(c)) ans += map.get(c);
            if (map.containsKey(d)) ans += map.get(d);
            
            map.put((n*1.0), map.getOrDefault((n*1.0), 0) + 1);
        }
        return ans;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        
        int[] pass = new int[N+1];
        int[] current = new int[N+1];
        
        for (int i =0; i<stages.length; i++) {
            for (int j = 0; j<stages[i]; j++) {
                pass[j] += 1;
            }
            current[stages[i]-1] += 1;
        }
        
        for (int i = 0; i<N; i++) {
            if (current[i] == 0 || pass[i] == 0) {
                map.put(i+1, 0.0);
            } else {
                map.put(i+1, (double) current[i]/(double) pass[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
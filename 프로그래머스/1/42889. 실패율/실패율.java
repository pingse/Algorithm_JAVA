import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        int[] current = new int[N+2];
        int arrLength = stages.length;
        int totalUser = arrLength;
        
        for (int a : stages) {
            current[a] += 1;
        }
        
        for (int i = 1; i<= N; i++) {
            if (totalUser == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) current[i] / totalUser);
            }
            totalUser -= current[i];
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
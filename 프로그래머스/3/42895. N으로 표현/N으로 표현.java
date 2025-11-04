import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i<=8; i++) {
            list.add(new HashSet<>());
            if (i == 0) continue;
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        list.get(1).add(N);
        
        for (int i = 2; i<=8; i++) {
            HashSet<Integer> total = list.get(i);
            for (int j = 1; j<i; j++) {
                HashSet<Integer> totalA = list.get(j);
                HashSet<Integer> totalB = list.get(i-j);
                
                for (int a : totalA) {
                    for (int b : totalB) {
                        total.add(a + b);
                        total.add(a - b);
                        total.add(a * b);
                        if (a != 0 && b != 0) total.add(a / b);
                    }
                }
            }
            
            if (total.contains(number)) return i;
        }
        return -1;
    }
}
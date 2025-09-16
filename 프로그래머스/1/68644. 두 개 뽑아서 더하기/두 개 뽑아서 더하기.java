import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i<numbers.length; i++) {
            for (int j = 0; j<numbers.length; j++) {
                if (i == j) continue;
                int n = numbers[i] + numbers[j];
                set.add(n);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
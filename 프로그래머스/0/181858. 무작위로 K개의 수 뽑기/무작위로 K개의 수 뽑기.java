import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i<arr.length; i++) {
            if (!set.contains(arr[i])) {
                answer[index++] = arr[i];
                set.add(arr[i]);
            }
            if (index == k) break;
        }
        
        if (index < k) {
            for (int i = index; i<k; i++) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
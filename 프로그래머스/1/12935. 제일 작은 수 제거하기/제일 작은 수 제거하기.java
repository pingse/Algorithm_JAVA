import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        if (arr.length == 1) {
            answer = new int[]{-1};
        } else {
            Arrays.sort(temp);
            int min = temp[0];
            for (int i : arr) {
                if (i != min) {
                    list.add(i);
                }
            }
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        return answer;
    }
}
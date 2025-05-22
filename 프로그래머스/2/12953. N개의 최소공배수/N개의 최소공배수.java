import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        
        while(true) {
            boolean state = false;
            for (int i = 0; i<arr.length; i++) {
                if (answer % arr[i] != 0) {
                    state = true;
                }
            }
            if (!state) {
                break;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
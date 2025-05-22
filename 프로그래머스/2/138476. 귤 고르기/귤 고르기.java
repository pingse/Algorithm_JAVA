import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        
        for (int i = 0; i<tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        
        Arrays.sort(arr);
        
        for (int i = 10000000; i>=0; i--) {
            if (k - arr[i] <= 0) {
                answer++;
                break;
            }  else {
                k-=arr[i];
                answer++;
            }
        }
        
        return answer;
    }
}
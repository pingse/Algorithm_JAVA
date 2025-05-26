import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int len = citations.length;
        
        for (int i = 0; i<len; i++) {
            if (len - i <= citations[i]) {
                answer = len - i;
                break;
            }
        }
        return answer;
    }
}
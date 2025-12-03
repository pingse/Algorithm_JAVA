import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] len = new int[31];
        int answer = 0;
        for (int i = 0; i<strArr.length; i++) {
            len[strArr[i].length()]++;
        }
        
        for (int i = 0; i<31; i++) {
            answer = Math.max(len[i], answer);
        }
        return answer;
    }
}
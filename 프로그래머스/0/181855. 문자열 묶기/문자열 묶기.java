import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] len = new int[31];
        int answer = 0;
        for (int i = 0; i<strArr.length; i++) {
            len[strArr[i].length()]++;
            answer = Math.max(answer, len[strArr[i].length()]);
        }
        return answer;
    }
}
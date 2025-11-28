import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        if (s / n == 0) answer = new int[]{-1};
        else {
            answer = new int[n];
            Arrays.fill(answer, s / n);
            for (int i = n-1; i>= n - (s%n); i--) {
                answer[i]++;
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        int i = 1;
        while (i <= n) {
            if (si < stations.length && stations[si] - w <= i) {
                i = stations[si] + w + 1;
                si++;
            } else {
                answer++;
                i += (2 * w) + 1;
            }
        }

        return answer;
    }
}
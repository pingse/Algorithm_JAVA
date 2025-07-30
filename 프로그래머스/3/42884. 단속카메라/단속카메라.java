import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int temp = -30001;
        
        for (int i = 0; i<routes.length; i++) {
            if (routes[i][0] > temp) {
                answer++;
                temp = routes[i][1];
            }
        }
        
        return answer;
    }
}
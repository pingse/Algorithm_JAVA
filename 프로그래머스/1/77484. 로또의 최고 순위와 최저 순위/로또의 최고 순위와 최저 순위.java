import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> win = new HashSet<>();
        for (int num : win_nums) {
            win.add(num);
        }
        int high = 0;
        int low = 0;
        int[] answer = {6, 6};
        
        for (int i = 0; i<lottos.length; i++) {
            int now = lottos[i];
            
            if (now == 0) {
                high++;
                if (high > 1) answer[0]--;
            } else {
                if (win.contains(now)) {
                    high++;
                    low++;
                    
                    if (high > 1) answer[0]--;
                    if (low > 1) answer[1]--;
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> win = new HashSet<>();
        for (int num : win_nums) {
            win.add(num);
        }
        int zero = 0;
        int same = 0;
        int high = 7;
        int low = 7;
        
        for (int i = 0; i<lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
            } else if (win.contains(lottos[i])) {
                same++;
            }
        }
        
        high -= (zero + same);
        low -= same;
        if (high > 6) high = 6;
        if (low > 6) low = 6;
        
        return new int[]{high, low};
    }
}
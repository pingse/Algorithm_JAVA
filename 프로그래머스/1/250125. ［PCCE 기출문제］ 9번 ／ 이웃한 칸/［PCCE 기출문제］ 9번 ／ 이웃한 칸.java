import java.util.*;

class Solution {
    int[] dh = {0, 1, -1, 0};
    int[] dw = {1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        for (int i = 0; i<4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            if (nh < 0 || nw < 0 || nh >= board.length || nw >= board.length) continue;
            
            if (board[nh][nw].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}
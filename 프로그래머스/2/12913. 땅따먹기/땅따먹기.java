import java.util.*;

class Solution {
    static int[][] dp;
    int solution(int[][] land) {
        int answer = 0;
        dp = new int[land.length][4];
        for (int i = 0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        
        if (land.length > 1) {
            for (int i = 1; i<land.length; i++) {
                for (int j = 0; j<4; j++) {
                    int max = 0;
                    for (int k = 0; k<4; k++) {
                        if (k == j) continue;
                        max = Math.max(dp[i-1][k], max);
                    }
                    dp[i][j] = max + land[i][j];
                }
            }
            
            for (int i = 0; i<4; i++) {
                answer = Math.max(dp[land.length-1][i], answer);
            }
        } else {
            for (int i = 0; i<4; i++) {
                answer = Math.max(dp[0][i], answer);
            }
        }

        return answer;
    }
}
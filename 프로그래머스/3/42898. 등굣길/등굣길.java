import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int[] coordinate : puddles) {
            map[coordinate[0]][coordinate[1]] = 1;
        }
        
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                
                if (map[i][j] == 0) {
                    dp[i][j] = Math.max(dp[i-1][j] + dp[i][j-1], dp[i][j]) % 1000000007;
                }
            }
        }
        return dp[m][n];
    }
}
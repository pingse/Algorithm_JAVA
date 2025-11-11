import java.util.*;

class Solution {
    public int solution(int[] money) {
        int max1 = dp(0, money.length - 2, money);
        int max2 = dp(1, money.length - 1, money);
        return Math.max(max1, max2);
    }
    
    int dp(int start, int end, int[] money) {
        int size = end - start + 1;
        int[] dp = new int[size];
        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start+1]);
        for (int i = 2; i<size; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[start + i]);
        }
        
        return dp[size-1];
    }
}
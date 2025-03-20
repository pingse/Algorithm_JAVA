import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        System.out.print(DP(n));
    }

    static int DP(int n) {
        if (n == 5) {
            return dp[n] = 1;
        } else if (n == 2) {
            return dp[n] = 1;
        }
        if (n >= 5) {
            if (dp[n] == 0) {
                if (DP(n - 5) > 0 && DP(n - 2) > 0) {
                    dp[n] = Math.min(DP(n - 5) + 1, DP(n - 2) + 1);
                } else if (DP(n - 5) == -1 && DP(n - 2) == -1) {
                    dp[n] = -1;
                } else if (DP(n - 5) > 0 || DP(n - 2) > 0) {
                    dp[n] = DP(n - 5) == -1 ? DP(n - 2) + 1 : DP(n - 5) + 1;
                }
            }
        } else {
            if (n % 2 != 0) {
                return dp[n] = -1;
            }
            dp[n] = DP(n-2) + 1;
        }
        return dp[n];
    }
}

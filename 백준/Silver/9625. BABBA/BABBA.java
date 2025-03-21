import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        System.out.print(dp[n][0] + " " + dp[n][1]);
    }
}

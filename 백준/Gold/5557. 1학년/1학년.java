import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[n+1];
        long[][] dp = new long[n][21];
        for (int i = 1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][nums[1]] = 1;

        for (int i = 2; i<n; i++) {
            for (int j = 0; j<21; j++) {
                if (dp[i-1][j] == 0) continue;

                if (j - nums[i] >= 0) dp[i][j-nums[i]] += dp[i-1][j];
                if (j + nums[i] < 21) dp[i][j+nums[i]] += dp[i-1][j];
            }
        }

        System.out.println(dp[n-1][nums[n]]);

    }
}

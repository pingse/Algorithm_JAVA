import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            DP(i);
        }
        Arrays.sort(dp);
        System.out.print(dp[n]);
    }

    static int DP(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;

            for (int i = n-1; i >=1; i--) {
                if (arr[n] < arr[i]) {
                    dp[n] = Math.max(DP(i) + 1, dp[n]);
                }
            }
        }
        return dp[n];
    }
}

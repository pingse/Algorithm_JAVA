import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n + 1][3];
        int[][][] dp = new int[n + 1][2][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]) + arr[i][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][0], Math.max(dp[i - 1][0][1], dp[i - 1][0][2])) + arr[i][1];
            dp[i][0][2] = Math.max(dp[i - 1][0][1], dp[i - 1][0][2]) + arr[i][2];

            dp[i][1][0] = Math.min(dp[i - 1][1][0], dp[i - 1][1][1]) + arr[i][0];
            dp[i][1][1] = Math.min(dp[i - 1][1][0], Math.min(dp[i - 1][1][1], dp[i - 1][1][2])) + arr[i][1];
            dp[i][1][2] = Math.min(dp[i - 1][1][1], dp[i - 1][1][2]) + arr[i][2];
        }
        int max = Math.max(dp[n][0][0], Math.max(dp[n][0][1], dp[n][0][2]));
        int min = Math.min(dp[n][1][0], Math.min(dp[n][1][1], dp[n][1][2]));

        System.out.print(max + " " + min);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = Integer.MAX_VALUE;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] < dp[i - 1][0]) {
                dp[i][0] = arr[i];
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(arr[i] - dp[i - 1][0], dp[i - 1][1]);
            }
        }
        System.out.print(dp[n][1]);
    }
}

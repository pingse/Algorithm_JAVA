import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][2];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dp[i][0] = 1;
                dp[i][1] = 1;
                max = 1;
            } else {
                if (arr[i - 1] < arr[i]) {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = 1;
                } else if (arr[i - 1] > arr[i]) {
                    dp[i][1] = dp[i - 1][1] + 1;
                    dp[i][0] = 1;
                } else {
                    dp[i][1] = dp[i-1][1] + 1;
                    dp[i][0] = dp[i-1][0] + 1;
                }
                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }
        }
        System.out.print(max);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] bags = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }


        int[][] dp = new int[n + 1][1000001];
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= 1000000; k++) {
                if (k >= arr[j][0]) {
                    dp[j][k] = Math.max(dp[j - 1][k - arr[j][0]] + arr[j][1], dp[j - 1][k]);
                } else {
                    dp[j][k] = dp[j - 1][k];
                }
            }
        }
        int ans = 1;
        double max = (double) dp[n][bags[1]] / bags[1];
        for (int i = 2; i <= m; i++) {
            if (max < (double) dp[n][bags[i]] / bags[i]) {
                max = (double) dp[n][bags[i]] / bags[i];
                ans = i;
            }
        }
        System.out.print(ans);

    }
}

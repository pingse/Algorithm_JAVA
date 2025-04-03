import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][h + 1];
        int[][] arr = new int[n + 1][m + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                if (st.hasMoreTokens()) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                for (int k = 1; k <= m; k++) {
                    if (arr[i][k] == 0) continue;
                    if (j - arr[i][k] >= 0) {
                        dp[i][j] += dp[i - 1][j - arr[i][k]];
                        dp[i][j] %= 10007;
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.print(dp[n][h]);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[3][n + 1][n + 1];
        int[][] arr = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[k][i][j] = Math.max(dp[k][i - 1][j], dp[k][i][j - 1]);
                }

                int k = arr[i][j];

                int temp = k == 0 ? 2 : k - 1;

                if (k == 0 || dp[temp][i - 1][j] != 0) {
                    dp[k][i][j] = Math.max(dp[k][i][j], dp[temp][i - 1][j] + 1);
                }
                if (k == 0 || dp[temp][i][j - 1] != 0) {
                    dp[k][i][j] = Math.max(dp[k][i][j], dp[temp][i][j - 1] + 1);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < 3; i++) {
            ans = Math.max(dp[i][n][n], ans);
        }
        System.out.print(ans);

    }
}

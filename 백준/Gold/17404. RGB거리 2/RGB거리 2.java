import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int ans = 1000001;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] rgb = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
                if (i == 1) dp[i][j] = rgb[i][j];
                else dp[i][j] = -1;
            }
        }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i ==j) dp[1][j] = rgb[1][j];
                    else dp[1][j] = 1000001;
                }
                for (int j = 2; j <= n; j++) {
                    dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + rgb[j][0];
                    dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + rgb[j][1];
                    dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + rgb[j][2];
                }

                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    ans = Math.min(dp[n][j], ans);
                }
            }
        
        System.out.print(ans);

    }
}

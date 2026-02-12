import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] route = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<m; j++) {
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[n][m][3];

        for (int i =0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        for (int j = 0; j < m; j++) {
            dp[0][j][0] = route[0][j];
            dp[0][j][1] = route[0][j];
            dp[0][j][2] = route[0][j];
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (j + 1 < m) {
                    dp[i][j][0] = route[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
                }
                dp[i][j][1] = route[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);

                if (j - 1 >= 0) {
                    dp[i][j][2] = route[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }
            }
        }

        for (int j = 0; j<m; j++) {
            for (int d = 0; d<3; d++) {
                answer = Math.min(dp[n-1][j][d], answer);
            }
        }

        System.out.println(answer);

    }
}

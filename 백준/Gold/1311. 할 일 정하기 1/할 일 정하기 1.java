import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int INF = 20*10000 + 1;
        int[][] map = new int[n+1][n+1];
        int[][] dp = new int[n+1][1<<(n+1)];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (1 << n+1); j++) {
                if (dp[i-1][j] == INF) continue;

                for (int k = 1; k <= n; k++) {
                    if ((j & (1<<k)) != 0) continue;
                    dp[i][j | (1 << k)] = Math.min(dp[i - 1][j] + map[i][k], dp[i][j | (1 << k)]);
                }
            }
        }
        System.out.print(dp[n][(1 << (n + 1)) - 2]);
    }
}

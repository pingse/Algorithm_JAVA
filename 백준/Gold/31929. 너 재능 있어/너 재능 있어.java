import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[] win, lose;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        win = new int[N+1];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(br.readLine());
        lose = new int[M+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(br.readLine());
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            win[i] = Integer.parseInt(st1.nextToken());
            dp[i][0] = dp[i - 1][0] + win[i];
        }
        for (int i = 1; i <= M; i++) {
            lose[i] = Integer.parseInt(st2.nextToken());
            if ((dp[0][i - 1] % K + K) % K == 0) {
                dp[0][i] = dp[0][i - 1] - lose[i];
            } else {
                dp[0][i] = dp[0][i-1] - Math.min((dp[0][i-1] % K + K) % K, lose[i]);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if ((dp[i][j - 1] % K + K) % K == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + win[i], dp[i][j - 1] - lose[j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + win[i], dp[i][j - 1] - Math.min((dp[i][j - 1] % K + K) % K, lose[j]));
                }
            }
        }

        System.out.print(dp[N][M]);
    }
}

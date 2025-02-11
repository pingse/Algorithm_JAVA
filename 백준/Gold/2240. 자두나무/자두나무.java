import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, W;
    static int[] plum;
    static int[][][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        plum = new int[T + 1];
        dp = new int[T + 1][W + 1][3];

        for (int i = 1; i <= T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }
        if (plum[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int i = 2; i <= T; i++) {
            if (plum[i] == 1) {
                dp[i][0][1] = dp[i-1][0][1] + 1;
                dp[i][0][2] = dp[i-1][0][2];

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]);
                }
            } else {
                dp[i][0][1] = dp[i-1][0][1];
                dp[i][0][2] = dp[i-1][0][2] + 1;

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]) + 1;
                }
            }
        }

        for (int i = 0; i <= W; i++) {
            max = Math.max(max, Math.max(dp[T][i][1], dp[T][i][2]));
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

}

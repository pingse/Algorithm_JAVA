import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());

        boolean[][] brokenN = new boolean[M+1][N+1];
        boolean[][] brokenM = new boolean[M+1][N+1];

        for (int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int sn = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());

            if (sn == en) {
                brokenM[Math.min(sm, em)][sn] = true;
            } else {
                brokenN[sm][Math.min(sn, en)] = true;
            }
        }

        long[][] dp = new long[M+1][N+1];

        dp[0][0] = 1;

        for (int i = 0; i<=M; i++) {
            for (int j = 0; j<=N; j++) {
                if (i>0 && !brokenM[i-1][j]) dp[i][j] += dp[i-1][j];
                if (j>0 && !brokenN[i][j-1]) dp[i][j] += dp[i][j-1];
            }
        }

        System.out.println(dp[M][N]);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[n + 1][m + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cheese = Integer.parseInt(st.nextToken());
            int potato = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= m; j++) {
                for (int z = 0; z <= k; z++) {
                    dp[i][j][z] = dp[i - 1][j][z];

                    if (j >= cheese && z >= potato) {
                        dp[i][j][z] = Math.max(dp[i - 1][j][z], dp[i - 1][j - cheese][z - potato] + 1);
                    }
                }
            }
        }
        System.out.print(dp[n][m][k]);
    }
}

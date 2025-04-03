import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] action = new int[3];
        for (int i = 0; i < 3; i++) {
            action[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][4];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], 1000001);
        }
        dp[0][0] = 0;

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < 4; j++) {
                if (dp[i][j] == 1000001) {
                    continue;
                }

                for (int k = 0; k < 3; k++) {
                    int a = 0;
                    switch (k) {
                        case 0:
                            a = 3;
                            break;
                        case 1:
                            a = 1;
                            break;
                        case 2:
                            a = 2;
                            break;
                    }
                    if (i + action[k] > K) {
                        continue;
                    }
                    dp[i + action[k]][(j + a) % 4] = Math.min(dp[i][j] + 1, dp[i + action[k]][(j + a) % 4]);
                }
            }
        }
        if (dp[K][0] == 1000001) {
            dp[K][0] = -1;
        }
        System.out.print(dp[K][0]);
    }
}

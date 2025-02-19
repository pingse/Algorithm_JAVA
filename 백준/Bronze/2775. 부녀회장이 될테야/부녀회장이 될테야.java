import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for (int i = 0; i <= 14; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int f = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            bw.write(dp[f][k] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

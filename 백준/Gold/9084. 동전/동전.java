import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] coin = new int[n + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (k - coin[j] > 0) {
                        dp[k] = dp[k] + dp[k - coin[j]];
                    } else if (k - coin[j] == 0) {
                        dp[k]++;
                    }
                }
            }
            bw.write(Integer.toString(dp[m]) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}

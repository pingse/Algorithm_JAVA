import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long count = 0;

        for (int i = 1; i < 10; i++) {
            count += dp(n, i);
        }
        bw.write(Long.toString(count % 1000000000));
        bw.flush();
        bw.close();
    }

    static long dp(int n, int val) {
        if (n == 1) {
            return dp[n][val];
        }

        if (dp[n][val] == null) {
            if (val == 9) {
                dp[n][val] = dp(n-1, 8);
            } else if (val == 0) {
                dp[n][val] = dp(n-1, 1);
            } else {
                dp[n][val] = dp(n-1, val-1) + dp(n-1, val+1);
            }
        }
        return dp[n][val] % 1000000000;
    }
}

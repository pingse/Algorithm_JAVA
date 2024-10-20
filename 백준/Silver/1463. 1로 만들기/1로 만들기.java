import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;
        bw.write(Integer.toString(dp(n)));
        bw.flush();
        bw.close();

    }

    static int dp(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(dp(n - 1), Math.min(dp(n / 2), dp(n / 3))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(dp(n / 3), dp(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(dp(n / 2), dp(n - 1)) + 1;
            } else {
                dp[n] = dp(n - 1) + 1;
            }
        }
        return dp[n];
    }
}

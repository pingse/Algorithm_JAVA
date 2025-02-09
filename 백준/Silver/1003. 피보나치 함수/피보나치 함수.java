import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            fibonacci(now);
            bw.write(Integer.toString(dp[now][0]) + " " + Integer.toString(dp[now][1]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return dp[n];
    }
}

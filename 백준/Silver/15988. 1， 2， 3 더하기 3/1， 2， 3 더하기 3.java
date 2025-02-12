import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long[] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp = new Long[1000001];
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for (int i = 4; i < 1000001; i++) {
            dp[i] =( dp[i-1] + dp[i-2] + dp[i-3] ) % 1000000009;
        }
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());
            bw.write(Long.toString(dp[next]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

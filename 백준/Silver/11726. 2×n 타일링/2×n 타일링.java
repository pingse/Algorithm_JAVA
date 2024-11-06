import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long[] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        dp = new Long[n+1];
        bw.write(Long.toString(fillTile(n)));
        bw.flush();
        bw.close();
    }

    static long fillTile(int n) {
        if (n == 0) {
            dp[0] = 0L;
            return dp[0];
        }
        if (n == 1) {
            dp[1] = 1L;
            return dp[1];
        }
        if (n == 2) {
            dp[2] = 2L;
            return dp[2];
        }

        if (dp[n] == null) {
            dp[n] = (fillTile(n - 1) + fillTile(n - 2)) %10007;
        }

        return dp[n];
    }
}

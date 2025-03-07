import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];
        System.out.print(binomial(n, k));

    }

    static int binomial(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        if (dp[n][k] == 0) {
            dp[n][k] = (binomial(n - 1, k - 1) + binomial(n - 1, k))%10007;
        }

        return dp[n][k];
    }
}

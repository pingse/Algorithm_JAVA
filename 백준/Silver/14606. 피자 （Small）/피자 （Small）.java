import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        System.out.print(DP(n));
    }

    static int DP(int n) {
        if (n == 2) {
            return dp[n] = 1;
        } else if (n == 1) {
            return 0;
        }

        if (dp[n] == 0) {
            int l = 0, r = 0;
            if (n % 2 == 0) {
                l = r = n / 2;
            } else {
                l = n/2+1;
                r = n/2;
            }

            dp[n] = l * r + DP(l) + DP(r);
        }
        return dp[n];
    }
}

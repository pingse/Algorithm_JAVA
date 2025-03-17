import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static double[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double k = Integer.parseInt(st.nextToken());

        dp = new double[n+1][m+1];
        getValue(n, m, k);

        if (check(n, m) < k) {
            System.out.print("-1");
        } else {
            System.out.print(sb.toString());
        }
    }

    static void getValue(int n, int m, double k) {
        if (n == 0) {
            for (int i = 0; i < m; i++) {
                sb.append("z");
            }
            return;
        } else if (m == 0) {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return;
        }

        double c = check(n - 1, m);

        if (k > c) {
            sb.append("z");
            getValue(n, m-1, k-c);
        } else {
            sb.append("a");
            getValue(n-1, m, k);
        }
    }

    static double check(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        return dp[n][m] = Math.min(check(n - 1, m) + check(n, m - 1), 1000000001);
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        if (m > n / 2) {
            System.out.print(0);
            return;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= m && j <= (i +1 ) / 2; j++) {
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;
            }
        }

        System.out.print((dp[n - 3][m - 1] + dp[n - 1][m]) % 1000000003);
    }
}

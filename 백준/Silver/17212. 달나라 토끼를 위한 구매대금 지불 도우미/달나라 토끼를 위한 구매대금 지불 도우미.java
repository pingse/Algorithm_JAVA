import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2 || i == 5 || i == 7) {
                dp[i] = 1;
            } else {
                if (i == 3 || i == 4) {
                    dp[i] = 2;
                } else if (i == 6) {
                    dp[i] = 2;
                } else {
                    dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 2], Math.min(dp[i - 5], dp[i - 7]))) + 1;
                }
            }
        }
        System.out.print(dp[n]);
    }
}

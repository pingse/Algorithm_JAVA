import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1] = 2;

        for (int i = 2; i <= 100000; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] % 16769023;
            } else {
                dp[i] = dp[i - 1] * 2 % 16769023;
            }
        }
        System.out.print(dp[n]);
    }
}

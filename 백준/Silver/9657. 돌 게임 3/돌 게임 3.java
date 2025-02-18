import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= 1000; i++) {
            dp[i] = 1;
            if (dp[i - 1] == 1 && dp[i - 3] == 1 && dp[i - 4] == 1) {
                dp[i] = 0;
            }
        }
        System.out.println(dp[n] == 1 ? "SK" : "CY");
    }
}

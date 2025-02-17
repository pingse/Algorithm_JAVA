import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String n = br.readLine();

        int[] dp = new int[n.length()+1];

        dp[0] = 1;
        for (int i = 1; i <= n.length(); i++) {
            int num = n.charAt(i-1) - '0';
            if (1 <= num && num <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            if (i == 1) continue;

            int num2 = n.charAt(i - 2) - '0';
            if (num2 == 0) continue;
            int two = num2 * 10 + num;
            if (10 <= two && two <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }
        System.out.print(dp[n.length()]);
    }
}

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println("0");
            System.exit(0);
        }

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }

        System.out.print(dp[n].toString());
    }
}

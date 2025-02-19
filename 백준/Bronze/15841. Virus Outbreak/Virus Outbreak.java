import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BigInteger[] dp = new BigInteger[491];
        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= 490; i++) {
            dp[i] = dp[i - 1].add(dp[i-2]);
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }

            bw.write("Hour " + n + ": " + dp[n] + " cow(s) affected\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

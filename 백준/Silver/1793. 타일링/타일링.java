import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String str;
        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3);
        for (int i = 3; i <= 250; i++) {
                dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            bw.write(dp[Integer.parseInt(str)].toString()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

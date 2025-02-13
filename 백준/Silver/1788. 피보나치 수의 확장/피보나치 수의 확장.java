import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());


        int[] dp = new int[Math.abs(n) + 1];
        dp[0] = 0;
        if (n != 0) {
            dp[1] = 1;

            for (int i = 2; i <= Math.abs(n); i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
            }
        }

        if (n > 0) {
            System.out.println(1);
        } else if (n < 0) {
            if (n % 2 != 0) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(0);
        }
        System.out.print(dp[Math.abs(n)]);
    }
}

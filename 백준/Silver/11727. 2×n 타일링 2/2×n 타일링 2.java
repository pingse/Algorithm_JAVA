import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        
        bw.write(Integer.toString(tile(n)));
        bw.flush();
        bw.close();
        br.close();

    }

    static int tile(int n) {
        if (n == 2) {
            return dp[2] = 3;
        }

        if (dp[n] == null) {
            dp[n] = (tile(n - 1) + (tile(n - 2) * 2)) % 10007;
        }
        return dp[n];
    }
}

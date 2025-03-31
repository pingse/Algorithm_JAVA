import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int[] dp = new int[c + 101];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j < dp.length; j++) {
                dp[j] = Math.min(dp[j - customer] + price, dp[j]);
            }
        }

        for (int i = c; i < dp.length; i++) {
            min = Math.min(dp[i], min);
        }
        System.out.print(min);
    }
}

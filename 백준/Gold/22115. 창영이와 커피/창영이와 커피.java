import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];

        st = new StringTokenizer(br.readLine(), " ");
        Arrays.fill(dp, 100000001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            for (int j = k; j >= c; j--) {
                dp[j] = Math.min(dp[j], dp[j - c] + 1);
            }
        }

        if (dp[k] > 100) {
            System.out.print("-1");
        } else {
            System.out.print(dp[k]);
        }
    }
}

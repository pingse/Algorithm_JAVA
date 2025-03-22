import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int money = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[11];

        dp[0] = money;
        dp[1] = (int) (money * 1.05);
        for (int i = 2; i < 11; i++) {
            if (i >= 5) {
                dp[i] = Math.max((int) (dp[i-5] * 1.35), Math.max((int) (dp[i-3] * 1.2), (int)(dp[i-1] * 1.05)));
            } else if (i < 5 && i >= 3) {
                dp[i] = Math.max((int) (dp[i - 3] * 1.2), (int) (dp[i - 1] * 1.05));
            } else {
                dp[i] = (int) (dp[i-1]*1.05);
            }
        }

        System.out.print(dp[n]);
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            int[] next = Arrays.copyOf(dp, x + 1);

            for (int j = 0; j <= x; j++) {
                if (dp[j] == 0) continue;

                for (int k = 1; k <= cnt; k++) {
                    int target = j + len * k;
                    if (target > x) break;
                    next[target] += dp[j];
                }
            }
            dp = next;
        }
        System.out.print(dp[x]);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<M; i++) {
            dp[Integer.parseInt(st.nextToken())] = -1;
        }

        for (int i = 1; i<=N; i++) {
            if (dp[i] == -1) {
                dp[i] = dp[i-1];
            } else {
                if (count == 0) {
                    dp[i] = 7;
                } else {
                    dp[i] = Math.min(dp[i - 1] + 7, dp[count] + (2 * (i - count)));
                }
                count = i;
            }
        }

        System.out.println(dp[N]);
    }
}

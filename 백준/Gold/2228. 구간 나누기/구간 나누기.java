import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];
        int[] prefix = new int[N+1];

        for (int i = 1; i<=N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            prefix[i] = prefix[i-1] + nums[i];
        }

        int[][] dp = new int[N+1][M+1];

        for (int i = 0; i<=N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][0] = 0;
        }

        for (int i = 1; i<=N; i++) {
            for (int j = 1; j<=M; j++) {
                dp[i][j] = dp[i-1][j];

                for (int k = 1; k<=i; k++) {
                    int prev = (k >= 2) ? dp[k-2][j-1] : (j == 1 ? 0 : Integer.MIN_VALUE);
                    if (prev == Integer.MIN_VALUE) continue;

                    int sum = prefix[i] - prefix[k-1];
                    dp[i][j] = Math.max(dp[i][j], prev + sum);
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}

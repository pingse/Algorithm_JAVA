import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] students = new int[N+1];

        for (int i = 1; i<=N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        for (int i = 1; i<=N; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;

            for (int k = i; k>=1; k--) {
                max = Math.max(max, students[k]);
                min = Math.min(min, students[k]);

                dp[i] = Math.max(dp[i], dp[k-1] + max - min);
            }
        }

        System.out.println(dp[N]);
    }
}

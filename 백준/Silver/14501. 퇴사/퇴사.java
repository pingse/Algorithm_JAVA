import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp;
    static int[] T;
    static int[] P;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new Integer[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(1));
    }

    static Integer dp(int n) {
        if (n > N) {
            return 0;
        }
        if (dp[n] == null) {
            if (T[n] + n <= N+1) {
                dp[n] = Math.max(dp(n+1), dp(T[n]+n) + P[n]);

            } else {
                dp[n] = dp(n + 1);
            }
        }
        return dp[n];
    }
}

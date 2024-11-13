import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;

    static int[] m;
    static int[] c;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N + 1];
        c = new int[N + 1];
        dp = new int[N+1][10001];
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= c[i]) dp[i][j] = m[i];
                } else {
                    if (j >= c[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if (dp[i][j] >= M) {
                    answer = Math.min(j, answer);
                }
            }
        }
        System.out.println(answer);

    }
}

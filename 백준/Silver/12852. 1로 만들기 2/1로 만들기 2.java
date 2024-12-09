import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dist = new int[N+1];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            dist[i] = i-1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i/2] + 1;
                dist[i] = i/2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                dist[i] = i/3;
            }
        }

        bw.write(Integer.toString(dp[N]) + "\n");
        int a = N;
        while (a > 0) {
            bw.write(Integer.toString(a) + " ");
            a = dist[a];
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

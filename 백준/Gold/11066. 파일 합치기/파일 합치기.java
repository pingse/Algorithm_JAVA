import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] file;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            file = new int[m+1];
            st = new StringTokenizer(br.readLine(), " ");
            dp = new int[m + 1][m + 1];
            int a = 0;

            file[1] = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= m; j++) {
                a = Integer.parseInt(st.nextToken());
                file[j] = file[j-1] + a;
            }

            for (int j = 1; j < m; j++) {
                for (int k = 1; k + j <= m; k++) {
                    dp[k][k+j] = Integer.MAX_VALUE;

                    for (int x = k; x < k + j; x++) {
                        dp[k][k + j] = Math.min(dp[k][k + j], dp[k][x] + dp[x + 1][k + j] + (file[k + j] - file[k-1]));
                    }
                }
            }

            System.out.println(dp[1][m]);
            file = null;
            dp = null;
        }
    }
}

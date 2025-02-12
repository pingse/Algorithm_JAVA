import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            int max = 0;

            int[][] arr = new int[now+1][2];
            int[][] dp = new int[now + 1][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= now; k++) {
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= now; j++) {
                dp[j][0] = Math.max(dp[j - 1][1], dp[j - 2][1]) + arr[j][0];
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 2][0]) + arr[j][1];
            }
            max = Math.max(dp[now][0], dp[now][1]);
            bw.write(Integer.toString(max) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

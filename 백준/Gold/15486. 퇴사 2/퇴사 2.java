import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] arr;
    static int[] dp;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N+2][2];
        dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N+1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int d = i + arr[i][0];

            if (d <= N + 1) {
                dp[d] = Math.max(dp[d], max + arr[i][1]);
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][2];
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = x; j >= 0; j--) {
                for (int k = 1; k <= arr[i][1]; k++) {
                    int value = j + arr[i][0] * k;
                    if (value <= x) {
                        dp[value] += dp[j];
                    }
                }
            }
        }
        System.out.print(dp[x]);

    }
}

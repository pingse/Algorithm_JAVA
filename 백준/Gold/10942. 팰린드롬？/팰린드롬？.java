import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] dp;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        palindrome();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write(dp[s][e] ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void palindrome() {
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
            if (arr[i] == arr[i - 1]) {
                dp[i-1][i] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n-i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j+i] = true;
                }
            }
        }
    }
}

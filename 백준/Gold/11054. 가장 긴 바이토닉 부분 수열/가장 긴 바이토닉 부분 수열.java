import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int[] arr;
    static Integer[] dp;
    static Integer[] dp2;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        dp2 = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            LIS(i);
            LIS2(arr.length - 1 - i);
        }
        int max = dp[0] + dp2[0] -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i] + dp2[i] - 1);
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

    static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }
        return dp[n];
    }

    static int LIS2(int n) {
        if (dp2[n] == null) {
            dp2[n] = 1;
            for (int i = n + 1; i < arr.length; i++) {
                if (arr[i] < arr[n]) {
                    dp2[n] = Math.max(dp2[n], LIS2(i) + 1);
                }
            }
        }
        return dp2[n];
    }

}

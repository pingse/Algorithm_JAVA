import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            int[] arr = new int[n + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    arr[j] = Integer.parseInt(st.nextToken());
                    dp[j] = 0;
                } else {
                    arr[j] = Integer.parseInt(st.nextToken());

                    if (arr[j - 1] >= arr[j]) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = dp[j - 1];
                    }
                }
            }
            bw.write("Case #" + Integer.toString(i + 1) + ": " + dp[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

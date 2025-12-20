import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int max = 0;

        int[] box = new int[n+1];
        for (int i = 1; i<=n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i<=n; i++) {
            dp[i] = 1;
            for (int j = 1; j<i; j++) {
                if (box[i] > box[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] matrix;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            dp[i][i+1] = matrix[i-1][0] * matrix[i][0] * matrix[i][1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j + i <= n; j++) {
                dp[j][i+j] = Integer.MAX_VALUE;
                for (int z = j; z < j + i; z++) {
                    dp[j][i + j] = Math.min(dp[j][i + j], dp[j][z] + dp[z + 1][i + j] + (matrix[j-1][0] * matrix[z-1][1] * matrix[i + j-1][1]));
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}

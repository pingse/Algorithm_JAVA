import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        dp = new int[matrix.length][matrix.length];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = matrix[i][0] * matrix[i+1][0] * matrix[i+1][1];
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int k = j + i;

                dp[j][k] = Integer.MAX_VALUE;
                for (int z = j; z < k; z++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][z] + dp[z + 1][k] + (matrix[j][0] * matrix[z][1] * matrix[k][1]));
                }
            }

        }

        bw.write(Integer.toString(dp[0][n-1]));
        bw.flush();
        bw.close();
    }

}

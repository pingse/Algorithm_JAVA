import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        board = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        dp();
        System.out.println(dp[n-1][n-1]);
    }

    static void dp() {
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board.length; j++) {
                if (board[i][j] == 0) return;

                int jump = board[i][j];
                if (i + jump < board.length) dp[i+jump][j] += dp[i][j];
                if (j + jump < board.length) dp[i][j+jump] += dp[i][j];
            }
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[][] dp;
    static Matrix[] matrix;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        matrix = new Matrix[n+1];
        dp = new Integer[matrix.length][matrix.length];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            matrix[i] = new Matrix(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        bw.write(Integer.toString(calMin(1, n)));
        bw.flush();
        bw.close();
    }

    static int calMin(int f, int s) {

        if (f == s) {
            return 0;
        }
        if (f + 1 == s) {
            return matrix[f].col * matrix[f].row * matrix[s].col;
        }
        if (dp[f][s] == null) {
            dp[f][s] = Integer.MAX_VALUE;
            for (int i = f; i < s; i++) {
                dp[f][s] = Math.min(dp[f][s], matrix[f].row * matrix[i].col * matrix[s].col +
                        calMin(f, i) +
                        calMin(i + 1, s));
            }
        }

        return dp[f][s];
    }

    static class Matrix {
        private int row;
        private int col;

        Matrix(int a, int b) {
            this.row = a;
            this.col = b;
        }
    }

}

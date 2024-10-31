import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int MOD = 1000;
    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD ;
            }
        }
        matrix = pow(matrix, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(Integer.toString(matrix[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static int[][] pow(int[][]matrix, long k) {
        if (k == 1) {
            return matrix;
        }

        int[][] newMatrix = pow(matrix, k / 2);

        newMatrix = multiple(newMatrix, newMatrix);

        if (k % 2 == 0) {
            return newMatrix;
        }

        return multiple(newMatrix, matrix);
    }

    static int[][] multiple(int[][] matrixA, int[][] matrixB) {
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    newMatrix[i][j] %= MOD;
                }
            }
        }
        return newMatrix;
    }
}

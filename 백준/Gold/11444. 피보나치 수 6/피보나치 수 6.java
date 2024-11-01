import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static long k = 1000000007;
    static long[][] A = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());

        long[][] result = cal(n - 1);
        bw.write(Long.toString(result[0][0]));
        bw.flush();
        bw.close();
    }

    static long[][] cal(long n) {
        if (n == 1 || n==0) {
            return A;
        }

        long[][] newA = cal(n/2);
        newA = pow(newA, newA);

        if (n % 2 == 0) {
            return newA;
        }
        return pow(A, newA);
    }

    static long[][] pow(long[][] a, long[][] b) {
        long[][] newA = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int z = 0; z < 2; z++) {
                    newA[i][j] += a[i][z]*b[z][j];
                    newA[i][j] %= k;
                }
            }
        }

        return newA;
    }
}

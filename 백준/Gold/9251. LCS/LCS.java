import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static char[] c;
    static char[] r;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        c = br.readLine().toCharArray();
        r = br.readLine().toCharArray();
        dp = new Integer[c.length][r.length];


        bw.write(Integer.toString(LCS(c.length - 1, r.length - 1)));
        bw.flush();
        bw.close();

    }

    static int LCS(int a, int b) {
        if (a == -1 || b == -1) {
            return 0;
        }
        if (dp[a][b] == null) {
            dp[a][b] = 0;

            if (c[a] == r[b]) {
                dp[a][b] = LCS(a - 1, b - 1) + 1;
            } else {
                dp[a][b] = Math.max(LCS(a - 1, b), LCS(a, b - 1));
            }
        }
        return dp[a][b];
    }
}


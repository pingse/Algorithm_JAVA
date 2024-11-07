import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] step;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        step = br.readLine().split(" ");
        dp = new int[5][5][step.length];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        bw.write(Integer.toString(calStep(0, 0, 0)));
        bw.flush();
        bw.close();
    }

    static int calStep(int l, int r, int c) {
        if (c == step.length - 1) {
            return 0;
        }

        if (dp[l][r][c] == -1) {
            dp[l][r][c] = Math.min(calStep(Integer.parseInt(step[c]), r, c + 1) + calForce(l, Integer.parseInt(step[c])),
                    calStep(l, Integer.parseInt(step[c]), c + 1) + calForce(r, Integer.parseInt(step[c])));
        }

        return dp[l][r][c];
    }

    static int calForce(int foot1, int foot2) {
        int force = Math.abs(foot2 - foot1);

        // 순서 제대로
        if (foot1 == 0) {
            return 2;
        } else if (force == 2) {
            return 4;
        } else if (force == 1 || force == 3) {
            return 3;
        } else {
            return 1;
        }
    }
}

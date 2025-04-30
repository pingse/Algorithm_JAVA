import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] dp = new int[5][4][1001];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] answer = new int[1001];
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j][1] = 1;
            }
        }
        dp[4][2][1] = dp[4][3][1] = 0;
        answer[1] = 10;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (j == 4 && k > 1) continue;
                    for (int z = 0; z < 4; z++) {
                        int ny = j + dy[z];
                        int nx = k + dx[z];
                        if (ny > 4 || ny < 1 || nx > 3 || nx < 1) continue;
                        dp[j][k][i] += dp[j + dy[z]][k + dx[z]][i - 1];
                    }
                    dp[j][k][i] %= 1234567;
                    answer[i] += dp[j][k][i];
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(answer[n]%1234567 + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

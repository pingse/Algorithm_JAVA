import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[][] dir = {
                {0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };
        int n = Integer.parseInt(br.readLine());

        int[][] pos = new int[n+1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        pos[0][0] = Integer.parseInt(st.nextToken());
        pos[0][1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n+1][5];

        for (int i = 0; i<5; i++) {
            int ny = pos[1][0] + dir[i][0];
            int nx = pos[1][1] + dir[i][1];

            dp[1][i] = dist(pos[0][1], pos[0][0], nx, ny);
        }

        for (int i = 2; i<=n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);

            for (int j = 0; j<5; j++) {
                int cy = pos[i][0] + dir[j][0];
                int cx = pos[i][1] + dir[j][1];

                for (int k = 0; k<5; k++) {
                    if (dp[i-1][k] == Long.MAX_VALUE) continue;

                    int py = pos[i-1][0] + dir[k][0];
                    int px = pos[i-1][1] + dir[k][1];

                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + dist(px, py, cx, cy));
                }
            }
        }

        long answer = Long.MAX_VALUE;

        for (int i = 0; i<5; i++) {
            answer = Math.min(dp[n][i], answer);
        }

        System.out.println(answer);
    }

    static long dist(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

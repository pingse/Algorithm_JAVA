import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int[][] dp;
    static int m;
    static int n;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m+1][n+1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(route(1,1));
    }

    static int route(int y, int x) {
        if (y == m && x == n) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int i = 0; i <4; i++) {
            int deltaX = x + dx[i];
            int deltaY = y + dy[i];

            if (deltaY < 1 || deltaX < 1 || deltaY > m  || deltaX > n ) {
                continue;
            }

            if (map[y][x] > map[deltaY][deltaX]) {
                dp[y][x] += route(deltaY, deltaX);
            }
        }

        return dp[y][x];
    }
}

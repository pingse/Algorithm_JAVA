import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited;
    static int[][] forest;
    static int[][] dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        forest = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (dp[i][j] != 0) max = Math.max(max, dp[i][j]);
                else max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);
    }

    static int dfs(int y, int x) {
        if (dp[y][x] != 0) return dp[y][x];

        int count = 0;

        for (int i = 0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= visited.length || nx >= visited.length) continue;
            if (forest[ny][nx] <= forest[y][x]) continue;

            visited[ny][nx] = true;
            count = Math.max(count, dfs(ny, nx));
            visited[ny][nx] = false;
        }

        dp[y][x] = count + 1;
        return dp[y][x];
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num = 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j, num++);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] > 1) {
                    bfs(i, j, map[i][j]);
                }
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x, int island) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n + 1][n + 1];
        queue.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != island) {
                min = Math.min(min, cur[2]-1);
            }
            if (cur[2] > min) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > n || ny < 1 || nx > n || nx < 1) continue;

                if (!visited[ny][nx] && map[ny][nx] != island) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx, cur[2] + 1});
                }
            }
        }
    }
    static void dfs(int y, int x, int num) {
        visited[y][x] = true;
        map[y][x] = num;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 1 || ny > n || nx < 1 || nx > n) continue;

            if (!visited[ny][nx] && map[ny][nx] == 1) {
                dfs(ny, nx, num);
            }
        }

    }
}

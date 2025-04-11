import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int max = 0;
    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        bfs();

        System.out.print(max);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if (visited[ny][nx] != 0 || map[ny][nx] == 1) continue;

                visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                max = Math.max(visited[ny][nx], max);
                queue.add(new int[]{ny, nx});
            }
        }
    }
}

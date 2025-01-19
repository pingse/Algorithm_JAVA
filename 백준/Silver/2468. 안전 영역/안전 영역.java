import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static Queue<int[]> queue;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            visited = new boolean[n + 1][n + 1];
            count = 0;
            queue = new LinkedList<>();

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        count++;
                        visited[j][k] = true;
                        queue.add(new int[]{j, k});
                        bfs(i);
                    }
                }
            }
            ans = Math.max(ans, count);
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(int m) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 1 || ny > n || nx < 1 || nx > n) continue;

                if (map[ny][nx] > m && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}

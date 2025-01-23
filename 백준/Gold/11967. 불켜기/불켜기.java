import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static int m;
    static boolean[][] visited;
    static boolean[][] light;
    static ArrayList<int[]>[][] queue;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1][n + 1];
        queue = new ArrayList[n + 1][n + 1];
        light = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                queue[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());
            int nextX = Integer.parseInt(st.nextToken());
            queue[y][x].add(new int[]{nextY, nextX});
        }
        bfs();
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        visited[1][1] = true;
        light[1][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (!queue[cur[0]][cur[1]].isEmpty()) {
                visited = new boolean[n + 1][n + 1];
                visited[cur[0]][cur[1]] = true;

                for (int[] next : queue[cur[0]][cur[1]]) {
                    if (!light[next[0]][next[1]]) {
                        light[next[0]][next[1]] = true;
                        count++;
                    }
                }
                queue[cur[0]][cur[1]].clear();
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > n || ny < 1 || nx > n || nx < 1) continue;

                if (!visited[ny][nx] && light[ny][nx]) {
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

    }
}

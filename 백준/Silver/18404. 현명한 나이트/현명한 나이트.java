import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] visited;
    static int n;
    static int m;
    static int curY, curX;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        curY = Integer.parseInt(st.nextToken());
        curX = Integer.parseInt(st.nextToken());
        queue.add(new int[]{curY, curX});

        bfs();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            bw.write(visited[y][x] + " ");
        }
        bw.flush();
        br.close();
        bw.close();

    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > n || ny < 1 || nx > n || nx < 1) continue;
                if (visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                queue.add(new int[]{ny, nx});
            }

        }
    }
}

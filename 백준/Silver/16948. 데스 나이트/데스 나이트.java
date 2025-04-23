import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, r1, r2, c1, c2;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        visited[r1][c1] = true;
        map[r1][c1] = 0;
        queue.add(new int[]{r1, c1});
        System.out.print(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                if (visited[ny][nx]) continue;
                if (ny == r2 && nx == c2) return map[cur[0]][cur[1]] + 1;

                visited[ny][nx] = true;
                map[ny][nx] = map[cur[0]][cur[1]] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
        return -1;
    }
}

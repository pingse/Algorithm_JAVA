import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[5][5];
    static int[][] visited = new int[5][5];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        System.out.print(bfs(X, Y));
    }

    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= 5 || ny < 0 || nx >=5 || nx < 0) continue;
                if (visited[ny][nx] != 0 || map[ny][nx] == -1) continue;

                if (map[ny][nx] == 1) {
                    return visited[cur[0]][cur[1]] + 1;
                }

                visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                queue.add(new int[]{ny, nx});
            }
        }

        return -1;
    }
}

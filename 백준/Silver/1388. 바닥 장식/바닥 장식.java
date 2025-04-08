import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    static boolean[][] visited;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        bfs();
        System.out.print(count);

    }

    static void bfs() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j]) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    char curC = map[cur[0]][cur[1]];

                    int ny = 0;
                    int nx = 0;
                    if (curC == '-') {
                        ny = cur[0];
                        nx = cur[1] + 1;
                    } else if (curC == '|') {
                        ny = cur[0] + 1;
                        nx = cur[1];
                    }

                    if (ny > n || ny < 1 || nx > m || nx < 1) continue;
                    if (visited[ny][nx]) continue;

                    if (map[ny][nx] == curC) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
                count++;
            }
        }

    }
}

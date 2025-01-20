import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int y;
    static int x;
    static int[][] iceberg;
    static boolean[][] visited;
    static int max;
    static Queue<int[]> queue;
    static int count = 0;
    static boolean state = false;
    static int year= 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        iceberg = new int[y+1][x+1];

        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= x; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, iceberg[i][j]);
            }
        }

        while(true) {
            visited = new boolean[y + 1][x + 1];
            queue = new LinkedList<>();
            count = 0;
            for (int i = 1; i <= y; i++) {
                for (int j = 1; j <= x; j++) {
                    if (!visited[i][j] && iceberg[i][j]> 0) {
                        dfs(i, j);
                        queue.add(new int[]{i, j});
                        count++;
                    }
                }
            }
            if (count >= 2) {
                state = true;
                break;
            } else {
                if (count == 0) {
                    break;
                } else {
                    bfs();
                    year++;
                }
            }
        }
        if (state) {
            bw.write(Integer.toString(year));
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int ny, int nx) {
        visited[ny][nx] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = ny + dy[i];
            int nextX = nx + dx[i];

            if (nextX < 1 || nextX > x || nextY < 1 || nextY > y) continue;

            if (!visited[nextY][nextX] && iceberg[nextY][nextX] > 0) {
                queue.add(new int[]{nextY, nextX});
                dfs(nextY, nextX);
            }
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 1 || ny > y || nx < 1 || nx > x) continue;

                if (!visited[ny][nx] && iceberg[ny][nx] == 0) {
                    iceberg[cur[0]][cur[1]]--;
                }
            }
            if (iceberg[cur[0]][cur[1]] < 0) {
                iceberg[cur[0]][cur[1]] = 0;
            }
        }
    }
}

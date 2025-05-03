import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int y, x;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.print(max);
    }
    static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] cMap = new int[y][x];
        for (int i = 0; i < y; i++) {
            cMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > y-1 || ny < 0 || nx > x-1 || nx < 0) continue;

                if (cMap[ny][nx] == 0) {
                    cMap[ny][nx] = 2;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        checkSafeArea(cMap);
    }

    static void checkSafeArea(int[][] checkMap) {
        int counting = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (checkMap[i][j] == 0) {
                    counting++;
                }
            }
        }

        max = Math.max(counting, max);
    }
}

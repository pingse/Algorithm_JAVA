import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] hy = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] hx = {-1, 1, -1, 1, 2, 2, -2, -2};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int y;
    static int x;
    static int K;
    static int[][] map;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[y + 1][x + 1];
        visited = new boolean[y+1][x+1][K+1];

        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[1][1][K] = true;
        min = bfs();
        bw.write(min == Integer.MAX_VALUE ? "-1" : Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0, K});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == y && cur[1] == x) return cur[2];

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > y || ny < 1 || nx > x || nx < 1) continue;

                if (!visited[ny][nx][cur[3]] && map[ny][nx] != 1) {
                    queue.add(new int[]{ny, nx, cur[2] + 1, cur[3]});
                    visited[ny][nx][cur[3]] = true;
                }
            }

            if (cur[3] > 0) {
                for (int i = 0; i < 8; i++) {
                    int hny = cur[0] + hy[i];
                    int hnx = cur[1] + hx[i];

                    if (hny > y || hny < 1 || hnx > x || hnx < 1) continue;

                    if (!visited[hny][hnx][cur[3] - 1] && map[hny][hnx] != 1) {
                        visited[hny][hnx][cur[3]-1] = true;
                        queue.add(new int[]{hny, hnx, cur[2] + 1, cur[3] - 1});
                    }
                }
            }
        }

        return min;
    }
}

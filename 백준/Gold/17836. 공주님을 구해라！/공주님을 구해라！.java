import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] counting;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];
        counting = new int[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if (!visited[N][M][0] && !visited[N][M][1]) {
            System.out.print("Fail");
        } else {
            int min = Integer.MAX_VALUE;
            if (visited[N][M][0]) min = Math.min(min, counting[N][M][0]);
            if (visited[N][M][1]) min = Math.min(min, counting[N][M][1]);
            if (min > T) System.out.print("Fail");
            else System.out.print(min);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});
        visited[1][1][0] = true;
        counting[1][1][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                int ns = cur[2];

                if (ny > N || ny < 1 || nx > M || nx < 1) continue;

                if (map[ny][nx] == 2) {
                    ns = 1;
                }

                if (map[ny][nx] == 1 && cur[2] != 1) continue;

                if(!visited[ny][nx][cur[2]]) {
                    visited[ny][nx][cur[2]] = true;
                    counting[ny][nx][ns] = counting[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{ny, nx, ns});
                }

            }

        }

    }
}

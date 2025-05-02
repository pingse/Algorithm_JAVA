import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map = new int[10][9];
    static boolean[][] visited = new boolean[10][9];
    static int[][] counting = new int[10][9];
    static int[] dy = {3, 3, 2, -2, -3, -3, 2, -2};
    static int[] dx = {-2, 2, 3, 3, -2, 2, -3, -3};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        map[r1][c1] = 1;
        st = new StringTokenizer(br.readLine(), " ");
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        map[r2][c2] = 2;
        bfs(r1, c1);
        System.out.print(visited[r2][c2] ? counting[r2][c2] : -1);
    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > 9 || ny < 0 || nx > 8 || nx < 0) continue;
                if (visited[ny][nx]) continue;

                switch (i) {
                    case 0:
                        if (map[cur[0] + 1][cur[1]] == 2 || map[cur[0] + 2][cur[1] - 1] == 2) continue;
                        break;
                    case 1:
                        if (map[cur[0] + 1][cur[1]] == 2 || map[cur[0] + 2][cur[1] + 1] == 2) continue;
                        break;
                    case 2:
                        if (map[cur[0]][cur[1] + 1] == 2 || map[cur[0] + 1][cur[1] + 2] == 2) continue;
                        break;
                    case 3:
                        if (map[cur[0]][cur[1] + 1] == 2 || map[cur[0] - 1][cur[1] + 2] == 2) continue;
                        break;
                    case 4:
                        if (map[cur[0] - 1][cur[1]] == 2 || map[cur[0] - 2][cur[1] - 1] == 2) continue;
                        break;
                    case 5:
                        if (map[cur[0] - 1][cur[1]] == 2 || map[cur[0] - 2][cur[1] + 1] == 2) continue;
                        break;
                    case 6:
                        if (map[cur[0]][cur[1] - 1] == 2 || map[cur[0] + 1][cur[1] - 2] == 2) continue;
                        break;
                    case 7:
                        if (map[cur[0]][cur[1] - 1] == 2 || map[cur[0] - 1][cur[1] - 2] == 2) continue;
                        break;
                }

                visited[ny][nx] = true;
                counting[ny][nx] = counting[cur[0]][cur[1]] + 1;
                if (ny == y && nx == x) return;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}

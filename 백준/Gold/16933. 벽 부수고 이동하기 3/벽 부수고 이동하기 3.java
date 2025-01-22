import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int y;
    static int x;
    static int K;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int day = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str;
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[y+1][x+1];
        visited = new boolean[y + 1][x + 1][K + 1];

        for (int i = 1; i <= y; i++) {
            str = br.readLine();
            for (int j = 1; j <= x; j++) {
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j - 1)));
            }
        }

        queue.add(new int[]{1, 1, 0, K, day});
        visited[1][1][K] = true;
        int min = bfs();
        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == y && cur[1] == x) {
                return cur[2]+1;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > y || ny < 1 || nx > x || nx < 1) continue;

                if (!visited[ny][nx][cur[3]] && map[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx, cur[2] + 1, cur[3], cur[4] == 1 ? 0 : 1});
                    visited[ny][nx][cur[3]] = true;
                }
            }
            if (cur[3] > 0) {
                for (int i = 0; i < 4; i++) {
                    int wny = cur[0] + dy[i];
                    int wnx = cur[1] + dx[i];

                    if (wny > y || wny < 1 || wnx > x || wnx < 1) continue;

                    if (!visited[wny][wnx][cur[3] - 1] && map[wny][wnx] == 1) {
                        if (cur[4] == 1) {
                            queue.add(new int[]{cur[0], cur[1], cur[2] + 1, cur[3], 0});
                        } else {
                            visited[wny][wnx][cur[3] - 1] = true;
                            queue.add(new int[]{wny, wnx, cur[2] + 1, cur[3] - 1, 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}

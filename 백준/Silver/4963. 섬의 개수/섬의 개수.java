import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited;
    static int[][] map;
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y == 0 && x == 0) break;

            int answer = 0;

            map = new int[y][x];
            visited = new boolean[y][x];

            for (int i = 0; i<y; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j<x; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i<y; i++) {
                for (int j = 0; j<x; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int y, int x) {
        for (int i = 0; i<8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= map.length || ny < 0 || nx >= map[0].length || nx < 0) continue;
            if (visited[ny][nx]) continue;

            if (map[ny][nx] == 1) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}

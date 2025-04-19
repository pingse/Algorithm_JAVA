import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map = new int[5][5];
    static boolean state;
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
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dfs(y, x, 0, 0);
        System.out.print(state ? 1 : 0);
    }

    static void dfs(int y, int x, int time, int count) {
        if (time > 3) return;
        if (count >= 2) {
            state = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny > 4 || nx > 4 || ny < 0 || nx < 0) continue;
            if (map[ny][nx] == -1) continue;
            int temp = map[y][x];

            map[y][x] = -1;
            dfs(ny, nx, time + 1, map[ny][nx] == 1 ? count+1 : count);
            map[y][x] = temp;
        }
    }
}

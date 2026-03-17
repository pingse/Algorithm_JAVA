import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map;
    static boolean[][] visited;
    static int[] answer = new int[2];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int R, C;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i<R; i++) {
            String str = br.readLine();

            for (int j = 0; j<C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#') visited[i][j] = true;
            }
        }

        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                if (map[i][j] == '#' || visited[i][j]) continue;

                bfs(i, j);
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.add(new int[]{r, c});
        int sheep = 0;
        int wolf = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (map[cur[0]][cur[1]] == 'o') sheep++;
            else if (map[cur[0]][cur[1]] == 'v') wolf++;

            for (int i = 0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (visited[ny][nx]) continue;

                queue.add(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }

        if (wolf < sheep) answer[0] += sheep;
        else answer[1] += wolf;
    }
}

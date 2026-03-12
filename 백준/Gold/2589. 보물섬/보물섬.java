import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int max = 0;

        map = new char[y][x];

        for (int i = 0; i<y; i++) {
            String str = br.readLine();
            for (int j = 0; j<x; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i<y; i++) {
            for (int j = 0; j<x; j++) {
                if (map[i][j] == 'W') continue;
                max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(max);
    }

    static int bfs(int y, int x) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        int max = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            max = Math.max(max, cur[2]);

            for (int i = 0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= visited.length || ny < 0 || nx >= visited[0].length || nx < 0) continue;
                if (map[ny][nx]=='W') continue;

                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, cur[2]+1});
            }
        }

        return max;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int[][] map = new int[n][n];

        StringTokenizer st;

        int sy = 0, sx = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sy = i;
                    sx = j;
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int sharkSize = 2;
        int eat = 0;

        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            queue.add(new int[]{sy, sx, 0});
            visited[sy][sx] = true;

            List<int[]> canEatFishes = new ArrayList<>();

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if (map[ny][nx] > sharkSize) continue;

                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;

                    if (map[ny][nx] > 0 && map[ny][nx] < sharkSize) {
                        canEatFishes.add(new int[]{ny, nx, cur[2] + 1});
                    }

                    queue.add(new int[]{ny, nx, cur[2] + 1});
                }
            }

            if (canEatFishes.isEmpty()) break;

            canEatFishes.sort((o1, o2) -> {
                if (o1[2] != o2[2]) return o1[2] - o2[2];
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            });

            int[] fish = canEatFishes.get(0);

            sy = fish[0];
            sx = fish[1];
            answer += fish[2];

            map[sy][sx] = 0;
            eat++;

            if (sharkSize == eat) {
                sharkSize++;
                eat = 0;
            }
        }

        System.out.println(answer);
    }
}

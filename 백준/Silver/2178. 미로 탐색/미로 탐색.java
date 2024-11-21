import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j - 1));
            }
        }

        bfs(1, 1);
        bw.write(Integer.toString(dist[N][M]));
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        dist[y][x]++;

        while (!queue.isEmpty()) {
            int[] recent = queue.poll();

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaX > 0 &&
                        deltaY > 0 &&
                        deltaX < map[0].length &&
                        deltaY < map.length &&
                        map[deltaY][deltaX] == 1 &&
                        !visited[deltaY][deltaX]) {
                    visited[deltaY][deltaX] = true;
                    dist[deltaY][deltaX] = dist[recent[0]][recent[1]] + 1;
                    queue.add(new int[]{deltaY, deltaX});
                }
            }
        }

    }
}

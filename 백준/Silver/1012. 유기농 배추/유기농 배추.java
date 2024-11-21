import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            count = 0;
            map = new int[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[y + 1][x + 1] = 1;
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        count++;
                        dfs(j, k);
                    }
                }
            }

            bw.write(Integer.toString(count) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int deltaY = y + dy[i];
            int deltaX = x + dx[i];
            if (deltaX > 0 && deltaX < map[0].length && deltaY > 0 && deltaY < map.length) {
                if (!visited[deltaY][deltaX] && map[deltaY][deltaX] == 1) {
                    dfs(deltaY, deltaX);
                }
            }
        }
    }
}

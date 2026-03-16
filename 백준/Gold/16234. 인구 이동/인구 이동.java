import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, L, R;
    static int[][] lands;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        lands = new int[N][N];
        int time = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lands[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean move = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (bfs(i, j)) move = true;
                }
            }

            if (!move) break;
            time++;
        }

        System.out.println(time);
    }

    static boolean bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>();

        queue.add(new int[]{y, x});
        union.add(new int[]{y, x});
        visited[y][x] = true;
        int sum = lands[y][x];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;

                int diff = Math.abs(lands[cur[0]][cur[1]] - lands[ny][nx]);
                if (diff < L || diff > R) continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
                union.add(new int[]{ny, nx});

                sum += lands[ny][nx];
            }
        }

        if (union.size() == 1) return false;

        int avg = sum / union.size();

        for (int[] next : union) {
            lands[next[0]][next[1]] = avg;
        }

        return true;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int s, x, y;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();

        visited = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                visited[i][j] = Integer.parseInt(st.nextToken());
                if (visited[i][j] != 0) {
                    list.add(new int[]{i, j, visited[i][j]});
                }
            }
        }
        Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);
        queue.addAll(list);

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        bfs();
        System.out.print(visited[x][y]);
    }

    static void bfs() {
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (time == s) return;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];

                    if (ny > n || ny < 1 || nx > n || nx < 1) continue;
                    if (visited[ny][nx] != 0) continue;

                    visited[ny][nx] = cur[2];
                    queue.add(new int[]{ny, nx, cur[2]});
                }
            }
            time++;
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int[][] size;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int p = 1;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            map = new int[n][n];
            size = new int[n][n];

            for (int i = 0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(size[i], INF);
                for (int j = 0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            bw.write("Problem " + p + ": " + size[n - 1][n - 1] + "\n");
            p++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{0, 0, 0});
        size[0][0] = map[0][0];

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int i = 0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= map.length || ny < 0 || nx >=map[0].length || nx < 0) continue;

                if (cur[2] > size[cur[0]][cur[1]]) continue;

                if (size[ny][nx] > size[cur[0]][cur[1]] + map[ny][nx]) {
                    size[ny][nx] = size[cur[0]][cur[1]] + map[ny][nx];
                    pq.add(new int[]{ny, nx, size[ny][nx]});
                }
            }
        }
    }
}

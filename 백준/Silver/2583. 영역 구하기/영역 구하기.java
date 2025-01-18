import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static boolean[][] visited;
    static int area;
    static int[] deltaY = {-1, 1, 0, 0};
    static int[] deltaX = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int y;
    static int x;
    static int count;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        map = new int[y + 1][x + 1];
        visited = new boolean[y + 1][x + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1 + 1; j <= y2; j++) {
                for (int k = x1 + 1; k <= x2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        for (int i = 1; i <=y; i++) {
            for (int j = 1; j <=x; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    area = 1;
                    count++;
                    queue.add(new int[]{i, j});
                    bfs();
                    list.add(area);
                }
            }
        }
        Collections.sort(list);
        bw.write(Integer.toString(count) + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(Integer.toString(list.get(i)) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = cur[0] + deltaY[i];
                int dx = cur[1] + deltaX[i];

                if (dy > y || dy < 1 || dx > x || dx < 1) continue;

                if (map[dy][dx] == 0 && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    area++;
                    queue.add(new int[]{dy, dx});
                }
            }
        }
    }
}

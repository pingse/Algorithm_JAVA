import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list;
    static int[][] map;
    static boolean[][] visited;
    static int H, W, O, F, Xs, Ys, Xe, Ye;
    static Queue<int[]> queue;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());
            Xs = Integer.parseInt(st.nextToken());
            Ys = Integer.parseInt(st.nextToken());
            Xe = Integer.parseInt(st.nextToken());
            Ye = Integer.parseInt(st.nextToken());

            map = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];
            for (int j = 0; j < O; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());

                map[x][y] = h;
            }

            queue = new LinkedList<>();
            queue.add(new int[]{Xs, Ys, F});
            visited[Xs][Ys] = true;
            bfs();
            bw.write(visited[Xe][Ye] ? "잘했어!!\n" : "인성 문제있어??\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nowF = cur[2];
            if (nowF == 0) continue;

            for (int i = 0; i < 4; i++) {
                int ny = cur[1] + dy[i];
                int nx = cur[0] + dx[i];

                if (nx > H || ny > W || nx < 1 || ny < 1) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] - map[cur[0]][cur[1]] > nowF) continue;

                visited[nx][ny] = true;
                if (nx == Xe && ny == Ye) return;

                queue.add(new int[]{nx, ny, nowF - 1});
            }
        }
    }
}

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] visited;
    static int[][] box;
    static int state = 0;
    static int max = 0;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        visited = new int[N + 1][M + 1];
        box = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        bfs();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j] == 0 && box[i][j] == 0) {
                    state = 1;
                    break;
                }
            }
            if (state == 1) {
                break;
            }
        }

        if (state == 1) {
            bw.write("-1");
        } else {
            if (max == 0) {
                bw.write("0");
            } else {
                bw.write(Integer.toString(max - 1));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] recent = queue.poll();

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaX > 0 && deltaX < box[0].length && deltaY > 0 && deltaY < box.length) {
                    if (visited[deltaY][deltaX] == 0 && box[deltaY][deltaX] == 0) {
                        queue.add(new int[]{deltaY, deltaX});
                        visited[deltaY][deltaX] = visited[recent[0]][recent[1]] + 1;
                        max = Math.max(max, visited[deltaY][deltaX]);
                    }
                }

            }
        }
    }
}

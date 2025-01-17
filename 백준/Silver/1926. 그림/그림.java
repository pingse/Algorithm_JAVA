import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int y;
    static int x;

    static int max = 0;
    static int count = 0;
    static int area = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        board = new int[y + 1][x + 1];
        visited = new boolean[y + 1][x + 1];

        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= x; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    bfs();
                    max = Math.max(area, max);
                }
            }
        }
        bw.write(Integer.toString(count) + "\n");
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] recent = queue.poll();
            if (!visited[recent[0]][recent[1]]) {
                visited[recent[0]][recent[1]] = true;
                count++;
                area = 1;
            }

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaX > 0 && deltaX <= x && deltaY > 0 && deltaY <= y) {
                    if (!visited[deltaY][deltaX] && board[deltaY][deltaX] == 1) {
                        queue.add(new int[]{deltaY, deltaX});
                        visited[deltaY][deltaX] = true;
                        area++;
                    }
                }
            }
        }
    }
}

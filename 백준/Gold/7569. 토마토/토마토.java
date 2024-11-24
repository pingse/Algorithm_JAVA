import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] box;
    static int[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static boolean state = false;
    static int max = 1;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        box = new int[Z + 1][Y + 1][X + 1];
        visited = new int[Z + 1][Y + 1][X + 1];

        for (int i = 1; i <= Z; i++) {
            for (int j = 1; j <= Y; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= X; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        visited[i][j][k] = 1;
                    }
                }
            }
        }
        bfs();
        for (int i = 1; i <= Z; i++) {
            for (int j = 1; j <= Y; j++) {
                for (int k = 1; k <= X; k++) {
                    if (visited[i][j][k] == 0 && box[i][j][k] == 0) {
                        state = true;
                        break;
                    }
                }
                if (state) {
                    break;
                }
            }
            if (state) {
                break;
            }
        }

        if (state) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(max-1));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] recent = queue.poll();
            for (int i = 0; i < 6; i++) {
                int deltaZ = recent[0] + dz[i];
                int deltaY = recent[1] + dy[i];
                int deltaX = recent[2] + dx[i];

                if (deltaY > 0 && deltaX > 0 && deltaZ > 0 &&
                        deltaX < visited[0][0].length &&
                        deltaY < visited[0].length &&
                        deltaZ < visited.length) {
                    if (visited[deltaZ][deltaY][deltaX] == 0 && box[deltaZ][deltaY][deltaX] == 0) {
                        queue.add(new int[]{deltaZ, deltaY, deltaX});
                        visited[deltaZ][deltaY][deltaX] = visited[recent[0]][recent[1]][recent[2]] + 1;
                        max = Math.max(max, visited[deltaZ][deltaY][deltaX]);
                    }
                }
            }
        }
    }
}

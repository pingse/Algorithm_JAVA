import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {2, 2, 1, -1, -2, -2, 1, -1};
    static int[] dx = {-1, 1, 2, 2, -1, 1, -2, -2};
    static int[][] visited;
    static int[][] dist = new int[2][2];
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            visited = new int[I + 1][I + 1];

            st = new StringTokenizer(br.readLine(), " ");
            dist[0][0] = Integer.parseInt(st.nextToken());
            dist[0][1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            dist[1][0] = Integer.parseInt(st.nextToken());
            dist[1][1] = Integer.parseInt(st.nextToken());

            if (dist[0][0] == dist[1][0] && dist[0][1] == dist[1][1]) {
                bw.write("0\n");
            } else {
                bfs(dist[0][0], dist[0][1]);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] recent = queue.poll();

            for (int i = 0; i < 8; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaY == dist[1][0] && deltaX == dist[1][1]) {
                    bw.write(Integer.toString(visited[recent[0]][recent[1]]) + "\n");
                    return;
                }

                if (deltaX >= 0 && deltaX < visited[0].length-1 && deltaY >= 0 && deltaY < visited.length-1) {
                    if (visited[deltaY][deltaX] == 0) {
                        queue.add(new int[]{deltaY, deltaX});
                        visited[deltaY][deltaX] = visited[recent[0]][recent[1]] + 1;
                    }
                }
            }
        }
    }
}

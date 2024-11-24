import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] board = new int[101];
    static int[] visited = new int[101];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladder + snake; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            board[from] = to;
        }
        queue.add(1);
        bfs();
        bw.write(Integer.toString(visited[100]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int recent = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = recent + i;
                if (next == 100) {
                    visited[next] = visited[recent] + 1;
                    return;
                }
                if (next < 100) {
                    if (board[next] != 0) {
                        next = board[next];
                    }
                    if (visited[next] == 0) {
                        queue.add(next);
                        visited[next] = visited[recent] + 1;
                    }
                }
            }
        }
    }

}

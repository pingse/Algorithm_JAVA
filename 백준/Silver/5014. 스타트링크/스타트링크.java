import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] visited;
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];
        queue.add(S);
        if (S == G) {
            bw.write("0");
        } else {
            int count = bfs();
            bw.write(count == 0 ? "use the stairs" : Integer.toString(count));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == G) {
                return visited[cur];
            }

            for (int i = 0; i < 2; i++) {
                int next = 0;
                if (i == 0) {
                    next = cur + U;
                } else {
                    next = cur - D;
                }

                if (next > F || next < 1) continue;

                if (visited[next] == 0) {
                    if (cur != next) {
                        visited[next] = visited[cur] + 1;
                        queue.add(next);
                    }
                }
            }
        }
        return 0;
    }
}

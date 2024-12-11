import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] visited;
    static int K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        if (N == K) {
            bw.write("0");
        } else {
            bfs(N);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int recent = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = recent -1;
                } else if (i == 1) {
                    next = recent + 1;
                } else if (i == 2) {
                    next = 2 * recent;
                }

                if (next == K) {
                    bw.write(Integer.toString(visited[recent]));
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[recent] + 1;
                }
            }
        }
    }
}

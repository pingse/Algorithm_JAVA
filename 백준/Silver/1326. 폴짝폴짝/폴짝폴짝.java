import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] bridge;
    static boolean[] visited;
    static int n, start, end;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        bridge = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        if (start == end) System.out.print(0);
        else System.out.print(bfs());
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = bridge[cur[0]];
            int next = cur[0];

            while (true) {
                next += num;

                if (next > n) break;
                if (visited[next]) continue;
                visited[next] = true;

                if (next == end) {
                    return cur[1] + 1;
                }
                queue.add(new int[]{next, cur[1] + 1});
            }

            while (true) {
                next -= num;
                if (next < 1) break;
                if (visited[next]) continue;
                visited[next] = true;

                if (next == end) {
                    return cur[1] + 1;
                }
                queue.add(new int[]{next, cur[1] + 1});
            }
        }
        return -1;
    }
}

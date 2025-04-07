import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n + 1][151];
        int[] small = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            small[Integer.parseInt(br.readLine())] = -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0});
        visited[1][0] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int j = 0; j<size; j++) {
                int[] cur = queue.poll();

                for (int i = -1; i < 2; i++) {
                    int jump = cur[1] + i;
                    if (jump < 1) {
                        continue;
                    }
                    int next = cur[0] + jump;

                    if (next > n || small[next] == -1) continue;
                    if (visited[next][jump]) continue;

                    if (next == n) {
                        System.out.print(step);
                        System.exit(0);
                    }
                    visited[next][jump] = true;
                    queue.add(new int[]{next, jump});
                }
            }
        }
        System.out.print("-1");
    }
}

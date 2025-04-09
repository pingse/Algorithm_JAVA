import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[end+1];
        visited[start] = true;
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start, 0});
        while (!queue.isEmpty()) {
            long[] cur = queue.poll();

            if (cur[0] == end) {
                System.out.print(cur[1] + 1);
                System.exit(0);
            }

            if (cur[0] * 2 <= end) {
                queue.add(new long[]{cur[0] * 2, cur[1] + 1});
                visited[(int) cur[0]*2] = true;
            }

            if (cur[0] * 10 + 1 <= end) {
                queue.add(new long[]{cur[0] * 10 + 1, cur[1] + 1});
                visited[(int) cur[0]*10+1] = true;
            }

        }

        System.out.print("-1");
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<int[]>> list;
    static long[] visited;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new long[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.get(u).add(new int[]{v, l});
            list.get(v).add(new int[]{u, l});
        }
        visited[1] = 0;

        System.out.print(bfs(1));
    }

    static long bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        long max = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < list.get(cur).size(); i++) {
                if (visited[list.get(cur).get(i)[0]] == -1) {
                    visited[list.get(cur).get(i)[0]] = visited[cur] + list.get(cur).get(i)[1];
                    max = Math.max(visited[list.get(cur).get(i)[0]], max);
                    queue.add(list.get(cur).get(i)[0]);
                }
            }
        }

        return max;
    }
}

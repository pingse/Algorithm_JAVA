import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list;
    static long[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            visited[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        System.out.print(bfs(r));
    }

    static long bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;
        int[] seq = new int[visited.length];
        int cnt = 1;
        seq[start] = cnt++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < list.get(cur).size(); i++) {
                if (visited[list.get(cur).get(i)] == -1) {
                    queue.add(list.get(cur).get(i));
                    visited[list.get(cur).get(i)] = visited[cur] + 1;
                    seq[list.get(cur).get(i)] = cnt++;
                }
            }
        }

        long ans = 0;

        for (int i = 1; i < visited.length; i++) {
            ans += visited[i] * seq[i];
        }

        return ans;
    }
}

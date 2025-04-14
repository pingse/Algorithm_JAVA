import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n + 1];


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

        queue.add(1);
        visited[1] = 0;
        bfs();
        int max = 0;
        int count = 0;
        int node = 0;

        for (int i = 1; i <= n; i++) {
            if (max == visited[i]) {
                count++;
            } else if (max < visited[i]) {
                max = visited[i];
                node = i;
                count = 1;
            }
        }
        System.out.print(node + " " + max + " " + count);
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : list.get(cur)) {
                if (visited[next] != -1) continue;

                visited[next] = visited[cur] + 1;
                queue.add(next);
            }
        }
    }
}

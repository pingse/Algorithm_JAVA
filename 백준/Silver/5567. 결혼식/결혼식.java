import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        bfs();
        System.out.println(count);
    }

    static void bfs() {
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();

        for (int next : graph[1]) {
            if (visited[next]) continue;
            visited[next] = true;
            count++;
            queue.add(next);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                count++;
            }
        }
    }
}

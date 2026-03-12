import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int x;
    static int y;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<t; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(x, 0);

        System.out.println(answer);

    }

    static void dfs(int s, int depth) {
        if (s == y) {
            answer = depth;
        }

        visited[s] = true;

        for (int next : graph[s]){
            if (visited[next]) continue;

            visited[next] = true;
            dfs(next, depth+1);
        }
    }
}

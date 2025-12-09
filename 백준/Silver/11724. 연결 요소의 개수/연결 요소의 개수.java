import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        graph = new ArrayList<>();

        for (int i = 0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N+1];

        for (int i = 1; i<=N; i++) {
            if (visited[i]) continue;
            answer++;
            dfs(i);
        }

        System.out.println(answer);
    }

    static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;

        for (int next : graph.get(start)) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}

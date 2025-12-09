import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        graph = new ArrayList[N+1];

        for (int i = 0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
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
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            for (int next : graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                stack.push(next);
            }
        }
    }
}

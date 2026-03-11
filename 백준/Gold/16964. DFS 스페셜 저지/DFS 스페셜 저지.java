import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] seq = new int[n];
        int[] order = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            order[seq[i]] = i;
        }

        for (int i = 1; i<=n; i++) {
            graph[i].sort((o1, o2) -> order[o1] - order[o2]);
        }

        dfs(1);

        for (int i = 0; i < n; i++) {
            if (answer.get(i) != seq[i]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    static void dfs(int start) {

        visited[start] = true;
        answer.add(start);

        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

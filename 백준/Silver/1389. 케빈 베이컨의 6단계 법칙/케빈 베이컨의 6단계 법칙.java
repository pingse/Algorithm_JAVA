import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] route;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int max = Integer.MAX_VALUE;

        route = new int[n+1][n+1];
        graph = new ArrayList[n+1];

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

        for (int i = 1; i<=n; i++) {
            bfs(i);
            int count = 0;
            for (int j = 1; j<=n; j++) {
                count += route[i][j];
            }
            route[i][i] = count;
            if (max > route[i][i]) {
                answer = i;
                max = route[i][i];
            }
        }

        System.out.println(answer);
    }

    static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int next : graph[cur[0]]) {
                if (start == next) continue;

                if (route[start][next] == 0) {
                    route[start][next] = cur[1] + 1;
                    queue.add(new int[]{next, cur[1]+1});
                }
            }
        }
    }
}

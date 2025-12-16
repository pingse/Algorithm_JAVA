import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int vCount = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;

        graph = new ArrayList[n+1];
        visited = new int[n+1];
        int[] hacking = new int[n+1];

        for (int i = 0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        for (int i = 1; i<=n; i++) {
            int c = bfs(i, n);
            max = Math.max(c, max);
            hacking[i] = c;
        }

        for (int i = 1; i<=n; i++) {
            if (hacking[i] == max) bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int count = 0;
        vCount++;
        visited[start] = vCount;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visited[next] == vCount) continue;

                visited[next] = vCount;
                count++;
                queue.add(next);
            }
        }

        return count;
    }
}

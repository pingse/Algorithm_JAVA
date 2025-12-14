import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<n; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i = 0; i<n; i++) {
            bw.write(bfs(n, i) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static String bfs(int n, int start) {

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int next : graph[start]) {
            if (visited[next]) continue;

            visited[next] = true;
            queue.add(next);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visited[next]) continue;

                visited[next] = true;
                queue.add(next);
            }
        }

        for (int i = 0; i<n; i++) {
            if (visited[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        return sb.toString();
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<node>> list = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;

    static class node {
        int v;
        int cost;

        public node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new node(v, w));
        }
        dijkstra(k);

        for (int i = 1; i<=V; i++) {
            bw.write(dist[i] == INF ? "INF\n" : Integer.toString(dist[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start) {
        PriorityQueue<node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            node n = queue.poll();

            if (!visited[n.v]) {
                visited[n.v] = true;
            }

            for (node next : list.get(n.v)) {
                if (!visited[next.v] && dist[next.v] > (n.cost+ next.cost)) {
                    dist[next.v] = n.cost + next.cost;
                    queue.add(new node(next.v, dist[next.v]));
                }
            }
        }
    }
}

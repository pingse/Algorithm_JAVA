import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<node>> list = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int INF = 200000000;

    static class node {
        int v;
        int length;

        public node(int v, int length) {
            this.v = v;
            this.length = length;
        }
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.get(u).add(new node(v, l));
            list.get(v).add(new node(u, l));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int first = 0;
        first += dijkstra(1, v1);
        first += dijkstra(v1, v2);
        first += dijkstra(v2, V);

        int second = 0;
        second += dijkstra(1, v2);
        second += dijkstra(v2, v1);
        second += dijkstra(v1, V);

        bw.write((first >= INF) && (second >= INF) ? "-1" : Integer.toString(Math.min(first, second)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<node> queue = new PriorityQueue<>((o1, o2) -> o1.length-o2.length);
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        queue.add(new node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            node n = queue.poll();

            if (!visited[n.v]) {
                visited[n.v] = true;

                for (node next : list.get(n.v)) {
                    if (!visited[next.v] && dist[next.v] > dist[n.v] + next.length) {
                        dist[next.v] = dist[n.v] + next.length;
                        queue.add(new node(next.v, dist[next.v]));
                    }
                }
            }

        }

        return dist[end];
    }
}

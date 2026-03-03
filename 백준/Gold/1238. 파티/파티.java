import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];

        for (int i = 1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, time));
            reverseGraph[end].add(new Node(start, time));
        }

        int[] time = dijkstra(X, graph);
        int[] reverseTime = dijkstra(X, reverseGraph);
        int answer = 0;

        for (int i = 1; i<=N; i++) {
            answer = Math.max(answer, time[i] + reverseTime[i]);
        }

        System.out.println(answer);
    }

    static int[] dijkstra(int start, ArrayList<Node>[] g) {
        int[] time = new int[g.length];
        Arrays.fill(time, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        time[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time > time[cur.to]) continue;

            for (Node next : g[cur.to]) {
                if (time[next.to] > time[cur.to] + next.time) {
                    time[next.to] = time[cur.to] + next.time;
                    pq.add(new Node(next.to, time[next.to]));
                }
            }
        }

        return time;
    }

    static class Node implements Comparable<Node> {
        int to;
        int time;

        Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}

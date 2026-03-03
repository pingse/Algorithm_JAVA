import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] times;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        times = new int[N+1][N+1];

        for (int i = 1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(times[i], INF);
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, time));
        }

        int answer = 0;

        for (int i = 1; i<=N; i++) {
            dijkstra(i);
        }

        for (int i = 1; i<=N; i++) {
            answer = Math.max(answer, times[i][X] + times[X][i]);
        }

        System.out.println(answer);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        times[start][start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time > times[start][cur.to]) continue;

            for (Node next : graph[cur.to]) {
                if (times[start][next.to] > times[start][cur.to] + next.time) {
                    times[start][next.to] = times[start][cur.to] + next.time;
                    pq.add(new Node(next.to, times[start][next.to]));
                }
            }
        }
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

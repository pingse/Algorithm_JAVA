import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] tower;
    static long[] answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static class Node {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tower = new int[N];
        answer = new long[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
            answer[i] = 10000000001L;

            if (i == N-1) continue;
            if (tower[i] == 1) visited[i] = true;
        }
        answer[0] = 0;


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }
        Dijkstra();
        System.out.print(answer[N - 1] == 10000000001L ? -1 : answer[N - 1]);
    }

    static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.w, o2.w));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Node next : list.get(cur.v)) {
                if (!visited[next.v] && answer[next.v] > cur.w + next.w) {
                    answer[next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, answer[next.v]));
                }
            }
        }

    }
}

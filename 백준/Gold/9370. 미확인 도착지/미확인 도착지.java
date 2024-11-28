import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class node {
        int v;
        int l;

        public node(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }

    static int[] dist;
    static ArrayList<ArrayList<node>> list;
    static int[] destination;
    static int INF = 100000000;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            destination = new int[t];
            visited = new boolean[N + 1];
            list = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                if ((u == v1 && v == v2) || (u == v2 && v == v1)) {
                    list.get(u).add(new node(v, (l * 2) - 1));
                    list.get(v).add(new node(u, (l * 2) - 1));
                } else {
                    list.get(u).add(new node(v, l * 2));
                    list.get(v).add(new node(u, l * 2));
                }
            }
            for (int j = 0; j < t; j++) {
                destination[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(destination);

            dijkstra(s);

            for (int value : destination) {
                if (dist[value] % 2 == 1) {
                    bw.write(Integer.toString(value) + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<node> queue = new PriorityQueue<>((o1, o2) -> o1.l - o2.l);
        queue.add(new node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            node n = queue.poll();

            if (!visited[n.v]) {
                visited[n.v] = true;

                for (node next : list.get(n.v)) {
                    if (!visited[next.v] && dist[next.v] > dist[n.v] + next.l) {
                        dist[next.v] = dist[n.v] + next.l;
                        queue.add(new node(next.v, dist[next.v]));
                    }
                }
            }
        }


    }
}

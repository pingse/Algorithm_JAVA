import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[] dist;
    static int[] destination;
    static int[] saveDist;
    static ArrayList<ArrayList<intersection>> list;
    static int INF = 50000001;

    static class intersection{
        int v;
        int l;

        public intersection(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            destination = new int[t];
            visited = new boolean[N + 1];
            dist = new int[N + 1];
            list = new ArrayList<>();
            saveDist = new int[N + 1];

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

                list.get(u).add(new intersection(v, l));
                list.get(v).add(new intersection(u, l));
            }
            for (int j = 0; j < t; j++) {
                destination[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(destination);

            dijkstra(s, 1);
            for (int j = 1; j <= N; j++) {
                saveDist[j] = dist[j];
            }

            int first = 0;
            first += dijkstra(s, v1);
            first += dijkstra(v1, v2);

            int second = 0;
            second += dijkstra(s, v2);
            second += dijkstra(v2, v1);
            for (int j = 0; j < t; j++) {
                int vFirst = first + dijkstra(v2, destination[j]);
                int vSecond = second + dijkstra(v1, destination[j]);

                int V = Math.min(vFirst, vSecond);
                int shortest = saveDist[destination[j]];

                if (!(vFirst >= INF && vSecond >= INF) && V == shortest) {
                    bw.write(Integer.toString(destination[j]) + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<intersection> queue = new PriorityQueue<>((o1, o2) -> o1.l - o2.l);
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        dist[start] = 0;
        queue.add(new intersection(start, 0));

        while (!queue.isEmpty()) {
            intersection n = queue.poll();

            if (!visited[n.v]) {
                visited[n.v] = true;

                for (intersection next : list.get(n.v)) {
                    if (!visited[next.v] && dist[next.v] > dist[n.v] + next.l) {
                        dist[next.v] = dist[n.v] + next.l;
                        queue.add(new intersection(next.v, dist[next.v]));
                    }
                }
            }

        }

        return dist[end];
    }
}

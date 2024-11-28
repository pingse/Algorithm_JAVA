import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited = new boolean[100001];
    static int[] time = new int[100001];
    static ArrayList<node>[] list = new ArrayList[100001];
    static int INF = 100001;

    static class node {
        int v;
        int second;

        public node(int v, int second) {
            this.v = v;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(time, INF);

        dijkstra(N, K);

        bw.write(Integer.toString(time[K]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<node> queue = new PriorityQueue<>((o1, o2) -> o1.second - o2.second);
        queue.add(new node(start, 0));
        time[start] = 0;

        while (!queue.isEmpty()) {
            node n = queue.poll();

            if (!visited[n.v]) {
                visited[n.v] = true;
            }

            if (n.v == end) {
                return;
            }

            int x = n.v;
            int s = 1;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    if (x * 2 <= INF - 1) {
                        x *= 2;
                        s = 0;
                    }
                } else if (i == 1) {
                    if (x + 1 <= INF - 1) {
                        x++;
                    }
                } else {
                    if (x - 1 >= 0) {
                        x--;
                    }
                }

                if (time[x] > time[n.v] + s) {
                    time[x] = time[n.v] + s;
                    queue.add(new node(x, time[x]));
                }
                x = n.v;
                s = 1;
            }
        }
    }
}

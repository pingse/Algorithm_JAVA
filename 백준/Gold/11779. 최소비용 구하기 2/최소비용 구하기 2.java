import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static ArrayList<ArrayList<bus>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int[] cityList;
    static Stack<Integer> stack = new Stack<>();

    static class bus implements Comparable<bus> {
        int v;
        int price;

        public bus(int v, int price) {
            this.v = v;
            this.price = price;
        }

        @Override
        public int compareTo(bus o) { // 비용 오름차순 정렬
            return this.price - o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        cityList = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            list.get(U).add(new bus(V, P));
        }
        st = new StringTokenizer(br.readLine(), " ");

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dijkstra(s);
        bw.write(dist[e] + "\n");
        while (e != 0) {
            stack.push(e);
            e = cityList[e];
        }
        bw.write(stack.size() + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pop() +" ");
        }
        bw.flush();
        bw.close();

    }

    static void dijkstra(int start) {
        PriorityQueue<bus> queue = new PriorityQueue<>();
        queue.add(new bus(start, 0));

        Arrays.fill(dist, 1000000001);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            bus current = queue.poll();

            if (!visited[current.v]) {
                visited[current.v] = true;
            } else {
                continue;
            }

            for (bus next : list.get(current.v)) {
                if (dist[next.v] > dist[current.v] + next.price) {
                    dist[next.v] = dist[current.v] + next.price;
                    cityList[next.v] = current.v;
                    queue.add(new bus(next.v, dist[next.v]));
                }
            }
        }
    }
}

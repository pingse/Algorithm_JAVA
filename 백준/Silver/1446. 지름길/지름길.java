import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PriorityQueue<Road> pQueue = new PriorityQueue<>();
    static int N;
    static int D;
    static int[] drive;
    static Road[] node;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        drive = new int[D + 1];
        node = new Road[N];

        for (int i = 0; i <= D; i++) {
            drive[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            node[i] = new Road(start, end, length);
        }
        dijkstra();
        System.out.print(drive[D]);
    }

    static void dijkstra() {
        pQueue.add(new Road(0, 0, 0));

        drive[0] = 0;

        while (!pQueue.isEmpty()) {
            Road cur = pQueue.poll();

            for (Road r : node) {
                if (r.s >= cur.d) {
                    if (r.d > D) continue;

                    if (drive[r.d] > drive[cur.d] + r.l + (r.s - cur.d)) {
                        drive[r.d] = drive[cur.d] + r.l + (r.s - cur.d);
                        pQueue.add(new Road(cur.d, r.d, drive[r.d]));
                    }
                }
            }

            drive[D] = Math.min(drive[D], drive[cur.d] + D - cur.d);
        }
    }

    static class Road implements Comparable<Road>{
        int s;
        int d;
        int l;

        public Road(int s, int d, int l) {
            this.s = s;
            this.d = d;
            this.l = l;
        }

        @Override
        public int compareTo(Road road) {
            return this.l - road.l;
        }
    }
}

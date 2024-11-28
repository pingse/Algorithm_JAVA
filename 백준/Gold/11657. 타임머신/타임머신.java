import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class bus{
        int u;
        int v;
        int second;

        public bus(int u, int v, int second) {
            this.u = u;
            this.v = v;
            this.second = second;
        }
    }

    static bus[] b;
    static long[] dist;
    static int INF = 60000001;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        b = new bus[M + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            b[i] = new bus(U, V, C);
        }

        if (bellmanford(1)) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    bw.write("-1\n");
                } else {
                    bw.write(Long.toString(dist[i]) + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();


    }

    static boolean bellmanford(int start) {
        dist[start] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int recent = b[j].u;
                int next = b[j].v;
                int sec = b[j].second;

                if (dist[recent] != INF) {
                    if (dist[next] > dist[recent] + sec) {
                        dist[next] = dist[recent] + sec;

                        if (i == N) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] graph;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = i;
        }

        int state;
        int a;
        int b;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            state = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (state == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return;
        }

        if (x <= y) {
            graph[y] = x;
        } else {
            graph[x] = y;
        }
    }

    static int find(int x) {
        if (x != graph[x]) {
            return graph[x] = find(graph[x]);
        }

        return graph[x];
    }
}

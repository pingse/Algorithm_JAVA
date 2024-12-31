import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] graph;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int next;

        graph = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                next = Integer.parseInt(st.nextToken());
                if (next == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int f = Integer.parseInt(st.nextToken());
        int answer = find(f);
        boolean isTrue = true;
        for (int i = 1; i < m; i++) {
            f = Integer.parseInt(st.nextToken());
            if (answer != find(f)) {
                isTrue = false;
                break;
            }
        }

        bw.write(isTrue ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int x = graph[a];
        int y = graph[b];

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
        if (x == graph[x]) {
            return x;
        } else {
            return graph[x] = find(graph[x]);
        }
    }
}

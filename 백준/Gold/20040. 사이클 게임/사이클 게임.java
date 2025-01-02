import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] graph;
    static boolean state = false;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = i;
        }

        int a;
        int b;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        if (state) {
            bw.write(Integer.toString(count));
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (!state)
            count++;

        if (x == y) {
            state = true;
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
        }
        return graph[x] = find(graph[x]);
    }
}

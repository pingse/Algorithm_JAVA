import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[] dist;
    static int n;
    static int max = 0;
    static int node;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();

    static class Node {
        int v;
        int l;

        public Node(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            list.get(U).add(new Node(V, L));
            list.get(V).add(new Node(U, L));
        }
        dfs(1, 0);

        max = 0;
        visited = new boolean[n + 1];
        dfs(node, 0);

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int l) {
        visited[start] = true;
        if (max < l) {
            max = l;
            node = start;
        }

        for (Node n : list.get(start)) {
            if (!visited[n.v]) {
                dfs(n.v, l + n.l);
            }
        }
    }
}

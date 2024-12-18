import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int node = 0;

    static class Node {
        int v;
        int l;

        public Node(int v, int l) {
            this.v = v;
            this.l = l;
        }
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int l = Integer.parseInt(st.nextToken());

                list.get(u).add(new Node(v, l));
            }
        }
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);
        System.out.println(max);
    }

    static void dfs(int start, int length) {
        if (max < length) {
            node = start;
            max = length;
        }
        visited[start] = true;

        for (Node cur : list.get(start)) {
            if (!visited[cur.v]) {
                dfs(cur.v, length + cur.l);
                visited[cur.v] = true;
            }
        }
    }
}

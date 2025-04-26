import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, count;
    static int[] tree;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            if (i == 0) continue;
            tree[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        dfs(1, 0);
        System.out.print(count);
    }

    static void dfs(int start, int parentColor) {
        visited[start] = true;

        if (tree[start] != parentColor) {
            count++;
        }

        for (int next : list.get(start)) {
            if (!visited[next]) {
                dfs(next, tree[start]);
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static long[] order, depth;
    static long cnt = 1;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        visited[R] = true;

        order = new long[N + 1];
        order[R] = 1;
        depth = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            depth[i] = -1;
        }
        depth[R] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        dfs(R, 1);

        long ans = 0;

        for (int i = 1; i <= N; i++) {
            ans += order[i] * depth[i];
        }
        System.out.print(ans);
    }

    static void dfs(int s, int d) {
        if (list.get(s).size() == 0) return;

        for (int next : list.get(s)) {
            if (visited[next]) continue;
            visited[next] = true;
            cnt++;
            order[next] = cnt;
            depth[next] = d;
            dfs(next, d + 1);
        }
    }
}

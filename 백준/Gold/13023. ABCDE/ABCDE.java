import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N, M;
    static boolean[] visited;
    static boolean isTrue = false;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 0);
        }
        System.out.print(isTrue ? 1 : 0);
    }

    static void dfs(int start, int depth) {
        if (isTrue) return;
        if (depth == 4) {
            isTrue = true;
            return;
        }
        visited[start] = true;

        for (int next : list.get(start)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[start] = false;
    }
}

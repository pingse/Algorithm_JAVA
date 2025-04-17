import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list;
    static boolean isTrue;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new int[n+1];
            isTrue = true;

            list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 1; j <= m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list.get(u).add(v);
                list.get(v).add(u);
            }

            bfs(1);

            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0) {
                    bfs(j);
                    if (!isTrue) break;
                }
            }

            bw.write(isTrue ? "possible\n" : "impossible\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : list.get(cur)) {
                if (visited[next] == visited[cur]) {
                    isTrue = false;
                    return;
                }

                if (visited[next] == 0) {
                    visited[next] = visited[cur] == 1 ? 2 : 1;
                    queue.add(next);
                }
            }
        }
    }
}

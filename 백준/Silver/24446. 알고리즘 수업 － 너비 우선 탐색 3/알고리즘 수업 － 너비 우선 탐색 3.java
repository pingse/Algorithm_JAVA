import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            visited[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        bfs(r);

        for (int i = 1; i <= n; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < list.get(cur).size(); i++) {
                if (visited[list.get(cur).get(i)] != -1) {
                    continue;
                }

                visited[list.get(cur).get(i)] = visited[cur] + 1;
                queue.add(list.get(cur).get(i));
            }
        }
    }
}

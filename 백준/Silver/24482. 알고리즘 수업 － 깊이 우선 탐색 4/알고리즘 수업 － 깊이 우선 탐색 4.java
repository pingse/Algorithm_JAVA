import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        list = new ArrayList<>();

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

        for (int i = 1; i <= n; i++) {
            list.get(i).sort(Collections.reverseOrder());
        }
        visited[r] = 0;
        dfs(r);

        for (int i = 1; i <= n; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        for (int i = 0; i < list.get(start).size(); i++) {
            if (visited[list.get(start).get(i)] == -1) {
                visited[list.get(start).get(i)] = visited[start]+1;
                dfs(list.get(start).get(i));
            }
        }
    }
}

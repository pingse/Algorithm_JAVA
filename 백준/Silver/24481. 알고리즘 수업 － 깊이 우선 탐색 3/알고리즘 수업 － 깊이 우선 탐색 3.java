import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list;
    static int[] node;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        node = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            node[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }
        node[r] = 0;
        dfs(r);

        for (int i = 1; i <= n; i++) {
            bw.write(node[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start) {
        for (int i = 0; i < list.get(start).size(); i++) {
            if (node[list.get(start).get(i)] == -1) {
                node[list.get(start).get(i)] = node[start] + 1;
                dfs(list.get(start).get(i));
            }
        }
    }
}

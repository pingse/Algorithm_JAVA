import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(list.get(i));
        }
        dfs(1);
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        visited[start] = true;
        if (start != 1) {
            count++;
        }

        for (Integer n : list.get(start)) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

}

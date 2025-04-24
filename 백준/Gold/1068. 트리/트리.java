import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, remove, root;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now == -1) {
                root = i;
                continue;
            }

            list.get(now).add(i);
            list.get(i).add(now);
        }

        remove = Integer.parseInt(br.readLine());

        dfs(root);
        System.out.print(count);
    }
    static void dfs(int start) {
        visited[start] = true;

        if (start == remove) return;
        int c = 0;
        for (int next : list.get(start)) {
            if (!visited[next] && next != remove) {
                c++;
                dfs(next);
            }
        }
        if (c == 0) {
            count++;
        }
    }
}

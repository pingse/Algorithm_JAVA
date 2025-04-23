import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int[]map;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        map = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (int i : list) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int start, int target) {
        if (!visited[map[start]]) {
            visited[map[start]] = true;
            dfs(map[start], target);
            visited[map[start]] = false;
        }

        if (map[start] == target) list.add(target);
    }
}

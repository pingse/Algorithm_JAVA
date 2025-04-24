import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] counting;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        counting = new int[n+1];
        StringTokenizer st;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            counting[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        counting[1] = 0;
        dfs(1);
        System.out.print(total % 2 == 1 ? "Yes" : "No");
    }

    static void dfs(int start) {
        int node = 0;

        for (int next : list.get(start)) {
            if (counting[next] == -1) {
                node++;
                counting[next] = counting[start] + 1;
                dfs(next);
            }
        }
        if (node == 0) {
            total += counting[start];
        }
    }
}

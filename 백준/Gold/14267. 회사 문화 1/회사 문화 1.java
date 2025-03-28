import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] list;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                continue;
            }
            list[x].add(i);
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            dp[num] += count;
        }
        dfs(1);
        for (int i = 1; i <= n; i++) {
            bw.write(dp[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int n) {
        for (int x : list[n]) {
            dp[x] += dp[n];
            dfs(x);
        }
    }
}

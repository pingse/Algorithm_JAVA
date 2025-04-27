import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static int[] results = new int[100001];
    static int L, R;
    static int value;
    static boolean result = false;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = L; i <= R; i++) {
            visited = new boolean[100001];
            result = false;
            value = 0;
            dfs(i);
            ans += value;
        }
        System.out.print(ans);
    }
    static void dfs(int start) {
        if (result) return;
        if (start > 100000) {
            value = -1;
            result = true;
            return;
        }
        if (visited[start]) {
            if (value == 0) {
                result = true;
                return;
            } else {
                return;
            }
        }

        visited[start] = true;
        if (results[start] == 0) {
            
            int l = 0;
            int r = 1;

            String str = Integer.toString(start);
            for (int i = 0; i < str.length(); i++) {
                l += str.charAt(i) - '0';
                r *= str.charAt(i) - '0';
            }
            str = Integer.toString(l) + Integer.toString(r);
            results[start] = Integer.parseInt(str);
        }
        if (results[start] == start) {
            value = 1;
            result = true;
            return;
        }
        dfs(results[start]);
    }
}

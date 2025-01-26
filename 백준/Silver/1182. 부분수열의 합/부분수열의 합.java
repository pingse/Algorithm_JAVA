import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (m == 0) {
            count--;
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int total) {
        if (depth == n) {
            if (total == m) {
                count++;
            }
            return;
        }
        dfs(depth + 1, total);
        dfs(depth + 1, total + arr[depth]);
    }
}

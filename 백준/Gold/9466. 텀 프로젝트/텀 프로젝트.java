import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static Queue<Integer> queue;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a = 0;
        while (a++ < t) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            queue = new LinkedList<>();
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (done[i]) continue;
                dfs(i);
            }
            bw.write(Integer.toString(n - count) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x) {
        if (done[x]) {
            return;
        }

        if (visited[x]) {
            done[x] = true;
            count++;
        }
        visited[x] = true;
        dfs(arr[x]);
        done[x] = true;
        visited[x] = false;
    }


}

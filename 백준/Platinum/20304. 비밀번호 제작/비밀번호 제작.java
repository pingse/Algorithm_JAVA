import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] safe = new int[1000001];
    static Queue<Integer> queue = new LinkedList<>();
    static int n, m;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Arrays.fill(safe, -1);

        for (int i = 0; i < m; i++) {
            int pass = Integer.parseInt(st.nextToken());
            queue.add(pass);
            safe[pass] = 0;
        }
        bfs();
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 20; i++) {
                int next = cur ^ (1 << i);

                if (next > n || safe[next] != -1) continue;

                queue.add(next);
                safe[next] = safe[cur] + 1;
                count = Math.max(safe[next], count);
            }
        }
    }
}

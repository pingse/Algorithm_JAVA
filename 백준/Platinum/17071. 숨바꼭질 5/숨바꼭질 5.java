import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int k;
    static int[] dest = new int[500001];
    static boolean[][] visited = new boolean[2][500001];
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited[0][n] = true;
        queue.add(new int[]{n, k, 0});
        bw.write(Integer.toString(bfs()));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int time = cur[2] + 1;
            int nk = cur[1] + time;

            if (cur[0] == cur[1]) {
                return cur[2];
            }

            if (nk > 500000) {
                return -1;
            }

            for (int i = 0; i < 3; i++) {
                int nn = cur[0];
                if (i == 0) {
                    nn -= 1;
                }
                else if (i == 1) {
                    nn += 1;
                } else {
                    nn *= 2;
                }


                if (nn < 1 || nn > 500000) {
                    continue;
                }

                if (!visited[time % 2][nn]) {
                    visited[time % 2][nn] = true;
                    queue.add(new int[]{nn, nk, cur[2] + 1});
                }
            }
            if (visited[time % 2][nk]) {
                return time;
            }
        }
        return -1;
    }
}

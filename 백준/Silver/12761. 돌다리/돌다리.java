import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited = new int[100001];
    static int a, b, n, m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(visited, -1);

        queue.add(n);
        visited[n] = 0;
        bfs();
        System.out.print(visited[m]);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int next = 0;
                switch(i) {
                    case 0:
                        next = cur + 1;
                        break;
                    case 1:
                        next = cur - 1;
                        break;
                    case 2:
                        next = cur + a;
                        break;
                    case 3:
                        next = cur - a;
                        break;
                    case 4:
                        next = cur + b;
                        break;
                    case 5:
                        next = cur - b;
                        break;
                    case 6:
                        next = cur * a;
                        break;
                    case 7:
                        next = cur * b;
                        break;
                }
                if (next > 100000 || next < 0) continue;
                if (visited[next] != -1) continue;

                visited[next] = visited[cur] + 1;
                if (next == m) return;
                queue.add(next);
            }
        }
    }
}

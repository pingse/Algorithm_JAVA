import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k, n;
    static char[][] route;
    static boolean[][] visited;
    static boolean win = false;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        String str1 = br.readLine();
        String str2 = br.readLine();
        route = new char[2][n + 1];
        visited = new boolean[2][n + 1];
        for (int i = 1; i <=n; i++) {
            route[0][i] = str1.charAt(i - 1);
            route[1][i] = str2.charAt(i - 1);
        }
        bfs();
        System.out.print(win ? 1 : 0);
    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1, 0});
        visited[0][1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[2] >= cur[1]) continue;
            if (cur[1] > n) {
                win = true;
                return;
            }

            if (cur[1] <= 0) continue;

            if (cur[1] + 1 <= n && route[cur[0]][cur[1] + 1] == '1' && !visited[cur[0]][cur[1] + 1]) {
                visited[cur[0]][cur[1]+1] = true;
                queue.add(new int[]{cur[0], cur[1] + 1, cur[2] + 1});
            }

            if (cur[1] - 1 > cur[2] && !visited[cur[0]][cur[1] - 1] && route[cur[0]][cur[1] -1] == '1') {
                visited[cur[0]][cur[1]-1] = true;
                queue.add(new int[]{cur[0], cur[1] - 1, cur[2] + 1});
            }

            int nextLine = cur[0] == 0 ? 1 : 0;
            if (cur[1] + k > n) {
                win = true;
                return;
            }

            if (route[nextLine][cur[1] + k] == '1' && !visited[nextLine][cur[1] + k]) {
                visited[nextLine][cur[1]+k] = true;
                queue.add(new int[]{nextLine, cur[1] + k, cur[2] + 1});
            }
        }
    }
}

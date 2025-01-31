import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] arr = new char[5][5];
    static boolean[] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count = 0;
    static int[] check = new int[7];
    public static void main(String[] args) throws IOException {
        String str;
        for (int i = 0; i < 5; i++) {
            str = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        backtracking(0, 0, 0);
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void backtracking(int depth, int s, int c) {
        if (depth - c > 3) return;

        if (depth == 7) {
            visited = new boolean[7];
            bfs(check[0]/5,check[0]%5);
            return;
        }

        for (int i = s; i < 25; i++) {
            check[depth] = i;
            backtracking(depth + 1, i + 1, (arr[i/5][i%5] == 'S') ? c+1 : c);
        }
    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[0] = true;
        int num = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > 4 || nx < 0 || ny < 0 || nx > 4) continue;

                int next = ny * 5 + nx;

                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && check[j] == next) {
                        visited[j] = true;
                        num++;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        if (num == 7) count++;
    }
}

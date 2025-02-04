import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, -1, 1, 1};
    static int[] dx = {-1, 1, -1, 1};
    static int n;
    static int[][] board;
    static boolean[][] isVisited;
    static int black = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 1, true, 0);
        dfs(1, 2, false, 0);
        bw.write(Integer.toString(black + white));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, boolean color, int cnt) {
        if (color) {
            black = Math.max(cnt, black);
        } else {
            white = Math.max(cnt, white);
        }

        if (x > n) {
            y++;
            x = color ? y % 2 == 0 ? 2 : 1 : y % 2 == 0 ? 1 : 2;
        }

        if (y > n) {
            return;
        }

        if (isBishop(y, x)) {
            isVisited[y][x] = true;
            dfs(y, x+2, color, cnt + 1);
            isVisited[y][x] = false;
        }
        dfs(y, x + 2, color, cnt);
    }

    static boolean isBishop(int y, int x) {
        if (board[y][x] == 0) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            for (int j = 1; j <= n; j++) {
                if (ny > n || nx > n || ny < 1 || nx <1) break;

                if (isVisited[ny][nx]) return false;
                ny+=dy[i];
                nx += dx[i];
            }
        }
        return true;
    }
}

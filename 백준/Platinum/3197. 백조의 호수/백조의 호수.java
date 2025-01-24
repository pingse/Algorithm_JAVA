import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> melt = new LinkedList<>();
    static int[][] destination = new int[2][2];
    static int day = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        String str;

        for (int i = 1; i <= R; i++) {
            str = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = str.charAt(j - 1);
                if (map[i][j] == 'L') {
                    if (destination[0][0] == 0) {
                        destination[0][0] = i;
                        destination[0][1] = j;
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    } else {
                        destination[1][0] = i;
                        destination[1][1] = j;
                    }
                    melt.add(new int[]{i, j});
                } else if (map[i][j] == '.') {
                    melt.add(new int[]{i, j});
                }
            }
        }

        while (true) {
            if (check()) {
                bw.write(Integer.toString(day));
                break;
            }
            melting();
            day++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check() {
        Queue<int[]> nq = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == destination[1][0] && cur[1] == destination[1][1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > R || ny < 1 || nx > C || nx < 1) continue;

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] == 'X') {
                        nq.add(new int[]{ny, nx});
                    } else {
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        queue = nq;
        return false;
    }

    static void melting() {
        Queue<int[]> nm = new LinkedList<>();

        while (!melt.isEmpty()) {
            int[] cur = melt.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > R || ny < 1 || nx > C || nx < 1) continue;

                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    nm.add(new int[]{ny, nx});
                }
            }
        }
        melt = nm;
    }
}

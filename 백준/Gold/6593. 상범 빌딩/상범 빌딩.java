import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static char[][][] map;
    static int[][][] visited;
    static Queue<int[]> queue;
    static int L;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L + 1][R + 1][C + 1];
            visited = new int[L + 1][R + 1][C + 1];
            queue = new LinkedList<>();

            for (int i = 1; i<=L; i++) {
                int count = 1;
                while (true) {
                    String str = br.readLine();
                    if (str.equals("")) {
                        break;
                    }
                    for (int j = 1; j <= str.length(); j++) {
                        map[i][count][j] = str.charAt(j - 1);
                        visited[i][count][j] = -1;
                        if (map[i][count][j] == 'S') {
                            queue.add(new int[]{i, count, j});
                        }
                    }
                    count++;
                }
            }
            int ans = bfs();

            if (ans == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + Integer.toString(ans) + " minute(s).\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (map[cur[0]][cur[1]][cur[2]] == 'E') {
                return visited[cur[0]][cur[1]][cur[2]] + 1;
            }

            for (int i = 0; i < 6; i++) {
                int nz = cur[0] + dz[i];
                int ny = cur[1] + dy[i];
                int nx = cur[2] + dx[i];

                if (nz < 1 || nz > L || ny < 1 || ny > R || nx < 1 || nx > C) continue;

                if (visited[nz][ny][nx] == -1 && map[nz][ny][nx] != '#') {
                    visited[nz][ny][nx] = visited[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{nz, ny, nx});
                }
            }
        }
        return -1;
    }
}

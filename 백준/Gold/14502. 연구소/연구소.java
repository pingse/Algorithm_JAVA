import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int y, x;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        List<int[]> empties = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    empties.add(new int[]{i, j});
                }
            }
        }

        int E = empties.size();
        for (int a = 0; a < E - 2; a++) {
            int[] w1 = empties.get(a);
            map[w1[0]][w1[1]] = 1;

            for (int b = a + 1; b < E - 1; b++) {
                int[] w2 = empties.get(b);
                map[w2[0]][w2[1]] = 1;

                for (int c = b + 1; c < E; c++) {
                    int[] w3 = empties.get(c);
                    map[w3[0]][w3[1]] = 1;

                    bfs();

                    map[w3[0]][w3[1]] = 0;
                }
                map[w2[0]][w2[1]] = 0;
            }
            map[w1[0]][w1[1]] = 0;
        }

        System.out.print(max);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>(list);

        int[][] cMap = new int[y][x];
        for (int i = 0; i < y; i++) {
            cMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > y-1 || ny < 0 || nx > x-1 || nx < 0) continue;

                if (cMap[ny][nx] == 0) {
                    cMap[ny][nx] = 2;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        checkSafeArea(cMap);
    }

    static void checkSafeArea(int[][] checkMap) {
        int counting = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (checkMap[i][j] == 0) {
                    counting++;
                }
            }
        }

        max = Math.max(counting, max);
    }
}

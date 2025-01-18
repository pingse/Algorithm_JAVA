import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] deltaY = {-1, 1, 0, 0};
    static int[] deltaX = {0, 0, -1, 1};
    static char[][] map;
    static int[][] visited1;
    static int[][] visited2;
    static int x;
    static int y;
    static Queue<int[]> queueF;
    static Queue<int[]> queueM;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            count = 0;

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map = new char[y + 1][x + 1];
            visited1 = new int[y + 1][x + 1];
            visited2 = new int[y + 1][x + 1];

            queueF = new LinkedList<>();
            queueM = new LinkedList<>();

            for (int j = 1; j <= y; j++) {
                str = br.readLine();
                for (int k = 1; k <= x; k++) {
                    map[j][k] = str.charAt(k - 1);
                    visited1[j][k] = -1;
                    visited2[j][k] = -1;

                    if (map[j][k] == '*') {
                        visited1[j][k] = 0;
                        queueF.add(new int[]{j, k});
                    } else if (map[j][k] == '@') {
                        visited2[j][k] = 0;
                        queueM.add(new int[]{j, k});
                    }
                }
            }
            bfsF();
            bfsM();

            if (count != 0) {
                bw.write(Integer.toString(count) + "\n");
            } else {
                bw.write("IMPOSSIBLE\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfsF() {
        while (!queueF.isEmpty()) {
            int[] cur = queueF.poll();

            for (int i = 0; i < 4; i++) {
                int dy = cur[0] + deltaY[i];
                int dx = cur[1] + deltaX[i];

                if (dx < 1 || dx > x || dy < 1 || dy > y) continue;

                if (map[dy][dx] != '#' && visited1[dy][dx] == -1) {
                    visited1[dy][dx] = visited1[cur[0]][cur[1]] + 1;
                    queueF.add(new int[]{dy, dx});
                }
            }
        }
    }

    static void bfsM() {
        while (!queueM.isEmpty()) {
            int[] cur = queueM.poll();

            for (int i = 0; i < 4; i++) {
                int dy = cur[0] + deltaY[i];
                int dx = cur[1] + deltaX[i];

                if (dx < 1 || dx > x || dy < 1 || dy > y ) {
                    count = visited2[cur[0]][cur[1]] + 1;
                    return;
                }
                if ((map[dy][dx] != '#' && visited2[dy][dx] == -1) && (visited1[dy][dx] == -1 || visited1[dy][dx] > visited2[cur[0]][cur[1]] + 1)) {
                    visited2[dy][dx] = visited2[cur[0]][cur[1]] + 1;
                    queueM.add(new int[]{dy, dx});
                }
            }
        }
    }
}

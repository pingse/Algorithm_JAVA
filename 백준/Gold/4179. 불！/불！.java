import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int x;
    static int y;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static char[][] map;
    static int[][] visitedJ;
    static int[][] visitedF;
    static int count = 0;
    static boolean state = false;
    static Queue<int[]> queueJ = new LinkedList<>();
    static Queue<int[]> queueF = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        String str;

        map = new char[y + 1][x + 1];
        visitedJ = new int[y + 1][x + 1];
        visitedF = new int[y + 1][x + 1];

        for (int i = 1; i <= y; i++) {
            str = br.readLine();
            for (int j = 1; j <= x; j++) {
                map[i][j] = str.charAt(j - 1);
                if (map[i][j] == 'J') {
                    queueJ.add(new int[]{i, j});
                    visitedJ[i][j] = 0;
                    visitedF[i][j] = -1;
                } else if (map[i][j] == 'F') {
                    queueF.add(new int[]{i, j});
                    visitedF[i][j] = 0;
                    visitedJ[i][j] = -1;
                } else {
                    visitedF[i][j] = -1;
                    visitedJ[i][j] = -1;
                }
            }
        }
        bfsF();
        bfsJ();

        if (count != 0) {
            bw.write(Integer.toString(count));
        } else {
            bw.write("IMPOSSIBLE");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfsJ() {
        while (!queueJ.isEmpty()) {
            int[] recent = queueJ.poll();

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaX == 0 || deltaX > x || deltaY > y || deltaY == 0) {
                    count = visitedJ[recent[0]][recent[1]] + 1;
                    return;
                }

                if (map[deltaY][deltaX] != '#' && visitedJ[deltaY][deltaX] == -1) {
                    visitedJ[deltaY][deltaX] = visitedJ[recent[0]][recent[1]] + 1;
                    if (visitedF[deltaY][deltaX] == -1 || (visitedJ[deltaY][deltaX] < visitedF[deltaY][deltaX])) {
                        queueJ.add(new int[]{deltaY, deltaX});
                    }
                }
            }
        }
    }

    static void bfsF() {
        while (!queueF.isEmpty()) {
            int[] recent = queueF.poll();

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaX > 0 && deltaX <= x && deltaY > 0 && deltaY <= y) {
                    if (map[deltaY][deltaX] != '#' && visitedF[deltaY][deltaX] == -1) {
                        visitedF[deltaY][deltaX] = visitedF[recent[0]][recent[1]] + 1;
                        queueF.add(new int[]{deltaY, deltaX});
                    }
                }
            }
        }
    }
}

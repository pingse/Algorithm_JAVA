import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visitedN;
    static boolean[][] visitedY;
    static Queue<int[]> queueN = new LinkedList<>();
    static Queue<int[]> queueY = new LinkedList<>();

    static int countN;
    static int countY;
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String str;

        visitedN = new boolean[n+1][n+1];
        visitedY = new boolean[n+1][n+1];
        map = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            str = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visitedY[i][j]) {
                    visitedY[i][j] = true;
                    queueY.add(new int[]{i, j});
                    bfsY();
                    countY++;
                }
                if (!visitedN[i][j]) {
                    visitedN[i][j] = true;
                    queueN.add(new int[]{i, j});
                    bfsN();
                    countN++;
                }
            }
        }

        bw.write(Integer.toString(countY) + " " + Integer.toString(countN));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfsN() {
        while (!queueN.isEmpty()) {
            int[] recent = queueN.poll();

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaY < 1 || deltaY > n || deltaX < 1 || deltaX > n) continue;

                if (!visitedN[deltaY][deltaX]) {
                    if (map[recent[0]][recent[1]] == 'R' || map[recent[0]][recent[1]] == 'G') {
                        if (map[deltaY][deltaX] == 'R' || map[deltaY][deltaX] == 'G') {
                            queueN.add(new int[]{deltaY, deltaX});
                            visitedN[deltaY][deltaX] = true;
                        }
                    } else {
                        if (map[recent[0]][recent[1]] == map[deltaY][deltaX]) {
                            queueN.add(new int[]{deltaY, deltaX});
                            visitedN[deltaY][deltaX] = true;
                        }
                    }
                }
            }
        }
    }

    static void bfsY() {
        while (!queueY.isEmpty()) {
            int[] recent = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int deltaY = recent[0] + dy[i];
                int deltaX = recent[1] + dx[i];

                if (deltaY > n || deltaY < 1 || deltaX > n || deltaX < 1) continue;

                if (!visitedY[deltaY][deltaX]) {
                    if (map[recent[0]][recent[1]] == map[deltaY][deltaX]) {
                        queueY.add(new int[]{deltaY, deltaX});
                        visitedY[deltaY][deltaX] = true;
                    }
                }
            }
        }
    }
}

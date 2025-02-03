import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n, m, g, r;
    static int[][] map;
    static boolean[] visited;
    static boolean[][] greenV, redV;
    static int[][] greenT, redT;
    static ArrayList<int[]> dfsList = new ArrayList<>();
    static ArrayList<int[]> green = new ArrayList<>();
    static ArrayList<int[]> red = new ArrayList<>();
    static int[][] map2;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    dfsList.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[dfsList.size()];
        dfsGreen(0, 0);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfsGreen(int depth, int s) {
        if (depth == g) {
            green.clear();
            for (int i = 0; i < dfsList.size(); i++) {
                if (visited[i]) {
                    int[] a = dfsList.get(i);
                    green.add(a);
                }
            }
            dfsRed(0, 0);
            return;
        }

        for (int i = s; i < dfsList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsGreen(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    static void dfsRed(int depth, int s) {
        if (depth == r) {
            red.clear();
            for (int i = 0; i < dfsList.size(); i++) {
                int[] a = dfsList.get(i);
                if (visited[i] && !green.contains(a)) {
                    red.add(a);
                }
            }
            bfs();
            return;
        }

        for (int i = s; i < dfsList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsRed(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void bfs() {
        int flower = 0;
        greenV = new boolean[n+1][m+1];
        greenT = new int[n+1][m+1];
        redV = new boolean[n+1][m+1];
        redT = new int[n+1][m+1];

        map2 = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map2[i][j] = map[i][j];
            }
        }

        Queue<int[]> rQ = new LinkedList<>();
        Queue<int[]> gQ = new LinkedList<>();

        for (int i = 0; i < red.size(); i++) {
            rQ.add(red.get(i));
            redV[red.get(i)[0]][red.get(i)[1]] = true;
        }
        for (int i = 0; i < green.size(); i++) {
            gQ.add(green.get(i));
            greenV[green.get(i)[0]][green.get(i)[1]] = true;
        }

        while (!gQ.isEmpty() && !rQ.isEmpty()) {
            if (!gQ.isEmpty()) {
                int gSize = gQ.size();
                while (gSize-- != 0) {
                    int[] cur = gQ.poll();
                    greenV[cur[0]][cur[1]] = true;

                    if (map2[cur[0]][cur[1]]==3) continue;

                    for (int i = 0; i < 4; i++) {
                        int ny = cur[0] + dy[i];
                        int nx = cur[1] + dx[i];

                        if (ny > n || ny < 1 || nx > m || nx < 1) continue;

                        if (!greenV[ny][nx] && (map2[ny][nx] == 1 || map2[ny][nx] == 2)) {
                            greenV[ny][nx] = true;
                            greenT[ny][nx] = greenT[cur[0]][cur[1]] + 1;
                            gQ.add(new int[]{ny, nx});
                        }
                    }

                }
            }
            if (!rQ.isEmpty()) {
                int rSize = rQ.size();

                while (rSize-- != 0) {
                    int[] cur = rQ.poll();
                    redV[cur[0]][cur[1]] = true;

                    if (map2[cur[0]][cur[1]] == 3) continue;

                    for (int i = 0; i < 4; i++) {
                        int ny = cur[0] + dy[i];
                        int nx = cur[1] + dx[i];

                        if (ny > n || ny < 1 || nx > m || nx < 1) continue;

                        if (!redV[ny][nx] && (map2[ny][nx] == 1 || map2[ny][nx] == 2)) {
                            redV[ny][nx] = true;
                            redT[ny][nx] = redT[cur[0]][cur[1]] + 1;
                            if (redT[ny][nx] == greenT[ny][nx]) {
                                flower++;
                                map2[ny][nx] = 3;
                            } else {
                                rQ.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }
        answer = Math.max(answer, flower);
    }
}

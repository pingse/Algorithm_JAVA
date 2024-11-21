import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] apartmentCount;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str;

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        apartmentCount = new int[25 * 25];

        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j - 1));
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        bw.write(Integer.toString(count) + "\n");
        Arrays.sort(apartmentCount);
        for (int n : apartmentCount) {
            if (n != 0) {
                bw.write(Integer.toString(n) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        apartmentCount[count]++;

        for (int i = 0; i < 4; i++) {
            if ((y + dy[i]) > 0 && (y + dy[i]) < map.length && (x + dx[i]) > 0 && (x + dx[i]) < map.length) {
                if (map[y + dy[i]][x + dx[i]] == 1 && !visited[y + dy[i]][x + dx[i]]) {
                    dfs(y + dy[i], x + dx[i]);
                }
            }
        }

    }
}

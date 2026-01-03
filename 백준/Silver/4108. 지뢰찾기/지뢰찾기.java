import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int[][] map;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (y == 0 && x == 0) break;

            map = new int[y][x];

            for(int i = 0; i<y; i++) {
                String str = br.readLine();
                for (int j = 0; j<x; j++) {
                    if (str.charAt(j) == '*') {
                        map[i][j] = -1;
                        for (int k = 0; k<8; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];

                            if (ny >= y || nx >= x || ny < 0 || nx < 0) continue;

                            if (map[ny][nx] == -1) continue;

                            map[ny][nx]++;
                        }
                    }
                }
            }

            for (int i = 0; i<y; i++) {
                for (int j = 0; j<x; j++) {
                    if (map[i][j] == -1) {
                        sb.append("*");
                    } else {
                        sb.append(map[i][j]);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int[][] map = new int[N][M];

        int answer = 0;

        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean moved = false;
            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }

            for (int i = 0; i<4; i++) {
                d = (d + 3) % 4;
                int ny = r + dy[d];
                int nx = c + dx[d];

                if (map[ny][nx] == 0) {
                    r = ny;
                    c = nx;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int back = (d + 2) % 4;

                int ny = r + dy[back];
                int nx = c + dx[back];

                if (map[ny][nx] == 1) {
                    break;
                }

                r = ny;
                c = nx;
            }
        }

        System.out.println(answer);
    }
}

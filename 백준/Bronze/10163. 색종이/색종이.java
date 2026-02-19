import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[1001][1001];
        int[] count = new int[101];

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            for (int i = sy; i < sy + ey; i++) {
                for (int j = sx; j < sx + ex; j++) {
                    if (map[i][j] != t) count[map[i][j]]--;
                    map[i][j] = t;
                    count[t]++;
                }
            }
        }

        for (int i = 1; i <= T; i++) {
            bw.write(count[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

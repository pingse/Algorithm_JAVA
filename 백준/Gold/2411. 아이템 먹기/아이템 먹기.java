import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int itemCount = Integer.parseInt(st.nextToken());
        int blockCount = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();

        boolean[][] map = new boolean[y + 1][x + 1];
        for (int i = 0; i < itemCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            list.add(new int[]{y1, x1});
        }
        for (int i = 0; i < blockCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            map[y1][x1] = true;
        }
        list.add(new int[]{1, 1});
        list.add(new int[]{y, x});
        list.sort((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int ans = 1;
        int[][] dp;
        for (int k = 1; k < list.size(); k++) {
            int curY = list.get(k)[0], curX = list.get(k)[1];
            int preY = list.get(k - 1)[0], preX = list.get(k - 1)[1];

            dp = new int[y + 1][x + 1];
            dp[preY][preX] = 1;

            for (int i = preY; i <= curY; i++) {
                for (int j = preX; j <= curX; j++) {
                    if (i == preY && j == preX) continue;

                    if (map[i][j]) dp[i][j] = 0;
                    else {
                        int way = 0;
                        if (i > preY) way += dp[i-1][j];
                        if (j > preX) way += dp[i][j - 1];
                        dp[i][j] = way;
                    }
                }
            }
            ans *= dp[curY][curX];
        }

        System.out.print(ans);
    }
}

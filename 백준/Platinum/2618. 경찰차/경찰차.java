import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp = new int[1001][1001];
    static int[][] event = new int[1001][2];
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            event[i][0] = Integer.parseInt(st.nextToken());
            event[i][1] = Integer.parseInt(st.nextToken());
        }
        bw.write(Integer.toString(search(1,0,0)) + "\n");

        int o = 0;
        int t = 0;

        for (int i = 1; i <= M; i++) {
            int D = getDistance(1, o, i);

            if (dp[o][t] - D == dp[i][t]) {
                o = i;
                bw.write("1\n");
            } else {
                t = i;
                bw.write("2\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int search(int e, int one, int two) {
        if (e > M) {
            return 0;
        }

        if (dp[one][two] != 0) {
            return dp[one][two];
        }

        int first = search(e+1, e, two) + getDistance(1, one, e);
        int second = search(e + 1, one, e) + getDistance(2, two, e);

        return dp[one][two] = Math.min(first, second);
    }

    static int getDistance(int police, int start, int to) {
        int[] st = event[start];
        int[] ed = event[to];

        if (start == 0) {
            if (police == 1) {
                st = new int[]{1, 1};
            } else {
                st = new int[]{N, N};
            }
        }

        return Math.abs(st[0] - ed[0]) + Math.abs(st[1] - ed[1]);
    }

}
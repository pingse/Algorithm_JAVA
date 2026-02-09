import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] chairs;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(br.readLine());
            return;
        }

        chairs = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j<n; j++) {
                chairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = findReward(0, 0, n/2);

        System.out.println(answer);
    }

    static int findReward(int y, int x, int range) {
        if (range == 1) {
            return second(chairs[y][x], chairs[y][x+1], chairs[y+1][x], chairs[y+1][x+1]);
        }

        return second(findReward(y, x, range/2),
                findReward(y, x + range, range/2),
                findReward(y+range, x, range/2),
                findReward(y+range, x+range, range/2));
    }

    static int second(int a, int b, int c, int d) {
        int min1 = Math.min(a, b);
        int max1 = Math.max(a, b);
        int min2 = Math.min(c, d);
        int max2 = Math.max(c, d);

        return Math.min(Math.min(max1, max2), Math.max(min1, min2));
    }
}

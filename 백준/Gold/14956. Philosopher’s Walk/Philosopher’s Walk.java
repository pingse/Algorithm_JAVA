import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ans = maze(m, n);
        System.out.print(ans[0] + " " + ans[1]);
    }

    static int[] maze(int walk, int size) {
        if (size == 2) {
            switch (walk) {
                case 1:
                    return new int[]{1, 1};
                case 2:
                    return new int[]{1, 2};
                case 3:
                    return new int[]{2, 2};
                case 4:
                    return new int[]{2, 1};
            }
        }
        int half = size/2;
        int area = (int) Math.pow(half, 2);

        if (walk <= area) {
            int[] ans = maze(walk, half);
            return new int[]{ans[1], ans[0]};
        } else if (walk > area && walk <= 2 * area) {
            int[] ans = maze(walk - area, half);
            return new int[]{ans[0], half + ans[1]};
        } else if (walk > 2*area && walk <= 3 * area) {
            int[] ans = maze(walk - 2 * area, half);
            return new int[]{half + ans[0],half + ans[1]};
        } else {
            int[] ans = maze(walk - 3 * area, half);
            return new int[]{size - ans[1] + 1, half - ans[0] + 1};
        }
    }
}

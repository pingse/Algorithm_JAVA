import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=N; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 1) house.add(new int[]{i, j});
                else if (now == 2) chicken.add(new int[]{i, j});
            }
        }

        comb(0, 0, new int[M]);
        System.out.println(answer);
    }

    static void comb(int depth, int start, int[] selected) {
        if (depth == M) {
            calculate(selected);
            return;
        }

        for (int i = start; i<chicken.size(); i++) {
            selected[depth] = i;
            comb(depth+1, i+1, selected);
        }
    }

    static void calculate(int[] selected) {
        int min = 0;

        for (int[] address1 : house) {
            int minDist = Integer.MAX_VALUE;

            for (int idx : selected) {
                int[] address2 = chicken.get(idx);
                int dist = Math.abs(address1[0] - address2[0]) + Math.abs(address1[1] - address2[1]);
                minDist = Math.min(dist, minDist);
            }
            min += minDist;
        }

        answer = Math.min(min, answer);
    }
}

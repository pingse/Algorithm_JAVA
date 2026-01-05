import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int top = 0; top < N; top++) {
            int[] temp = new int[M];

            for (int bottom = top; bottom < N; bottom++) {
                for (int col = 0; col < M; col++) {
                    temp[col] += map[bottom][col];
                }

                answer = Math.max(answer, kadane(temp));
            }
        }

        System.out.println(answer);
    }

    static int kadane(int[] arr) {
        int max = arr[0];
        int cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(max, cur);
        }

        return max;
    }
}

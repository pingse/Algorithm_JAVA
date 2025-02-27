import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int end = 0;
        int[] snack = new int[N];
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, snack[i]);
        }

        int start = 1;
        while (start <= end) {
            int mid = (start + end) /2;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (snack[i] >= mid) {
                    count += snack[i] / mid;
                }
            }

            if (count >= M) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        System.out.println(end);
    }
}

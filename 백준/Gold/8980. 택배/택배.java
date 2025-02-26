import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        } );

        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = c;
        }

        int answer = 0;

        for (int i = 0; i < m; i++) {
            int capacity = Integer.MAX_VALUE;

            for (int j = arr[i][0]; j < arr[i][1]; j++) {
                capacity = Math.min(capacity, count[j]);
            }
            if (capacity >= arr[i][2]) {
                for (int j = arr[i][0]; j < arr[i][1]; j++) {
                    count[j] -= arr[i][2];
                }
                answer += arr[i][2];
            } else {
                for (int j = arr[i][0]; j < arr[i][1]; j++) {
                    count[j] -= capacity;
                }
                answer += capacity;
            }
        }

        System.out.print(answer);
    }
}

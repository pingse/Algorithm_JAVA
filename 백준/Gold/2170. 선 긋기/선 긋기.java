import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int answer = 0;
        int first = arr[0][0];
        int second = arr[0][1];

        for (int i = 1; i < n; i++) {
            if (second < arr[i][0]) {
                if (first < 0 && second > 0) {
                    answer += Math.abs(first) + second;
                } else if (first < 0 && second < 0) {
                    answer += Math.abs(first) - Math.abs(second);
                } else {
                    answer += second - first;
                }
                first = arr[i][0];
                second = arr[i][1];
                continue;
            }

            if (second >= arr[i][1]) {
                continue;
            } else {
                second = arr[i][1];
            }
        }
        if (first < 0 && second > 0) {
            answer += Math.abs(first) + second;
        } else if (first < 0 && second < 0) {
            answer += Math.abs(first) - Math.abs(second);
        } else {
            answer += second - first;
        }

        System.out.print(answer);

    }
}

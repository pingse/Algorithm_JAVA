import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] numAB = new int[n * n];
        int[] numCD = new int[n * n];

        int[][] num = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
            num[i][2] = Integer.parseInt(st.nextToken());
            num[i][3] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numAB[idx] = num[i][0] + num[j][1];
                numCD[idx++] = num[i][2] + num[j][3];
            }
        }
        Arrays.sort(numAB);
        Arrays.sort(numCD);

        int start = 0;
        int end = n * n - 1;
        long answer = 0;

        while (start < n * n && end >= 0) {
            int sum = numAB[start] + numCD[end];

            if (sum == 0) {
                long r = 1;
                long l = 1;

                while (start < n * n - 1 && numAB[start] == numAB[start + 1]) {
                    l++;
                    start++;
                }
                while (end > 0 && numCD[end] == numCD[end - 1]) {
                    r++;
                    end--;
                }
                answer += r * l;
                start++;
                end--;
            } else if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.print(answer);
    }
}

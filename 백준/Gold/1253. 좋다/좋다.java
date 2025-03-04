import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        if (n < 3) {
            System.out.print("0");
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }
                else if (end == i) {
                    end--;
                    continue;
                }

                if (num[i] == num[start] + num[end]) {
                    answer++;
                    break;
                }

                if (num[start] + num[end] < num[i]) {
                    start++;
                } else if (num[start] + num[end] > num[i]) {
                    end--;
                }
            }
        }
        System.out.print(answer);

    }
}

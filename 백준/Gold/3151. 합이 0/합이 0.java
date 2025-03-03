import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            if (num[i] > 0) break;
            int now = num[i];
            int start = i+1;
            int end = n-1;

            while (start < end) {
                int sum = now + num[start] + num[end];

                if (sum == 0) {
                    int left = 1;
                    int right = 1;

                    if (num[start] == num[end]) {
                        int value = end - start + 1;
                        count += (value * (value-1)) / 2;
                        break;
                    }

                    while (num[start] == num[start + 1]) {
                        left++;
                        start++;
                    }
                    while (num[end] == num[end - 1]) {
                        right++;
                        end--;
                    }
                    count += left * right;
                }

                if (sum > 0) {
                    end--;
                } else {
                    start++;
                }

            }
        }
        System.out.print(count);
    }
}

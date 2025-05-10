import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long l = 1;
        long r = 1000000000;
        long temp = 0;
        long sum = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            int count = 0;

            for (int i = 0; i < s; i++) {
                count += arr[i]/mid;
            }

            if (count >= c) {
                temp = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        for (int chicken : arr) {
            sum += chicken;
        }

        long answer = sum - (temp * c);
        System.out.print(answer);
    }
}

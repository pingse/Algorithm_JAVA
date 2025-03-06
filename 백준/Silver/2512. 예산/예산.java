import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int end = -1;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, num[i]);
        }
        int start = 0;
        long m = Long.parseLong(br.readLine());
        while (start <= end) {
            int mid = (start + end)/2;
            long answer = 0;

            for (int i = 0; i < n; i++) {
                if (num[i] > mid) answer+=mid;
                else answer += num[i];
            }
            if (m < answer) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.print(end);
    }
}

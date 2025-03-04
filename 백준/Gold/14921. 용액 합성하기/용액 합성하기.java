import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int start = 0;
        int end = n-1;
        int answer = Integer.MAX_VALUE;
        while (start < end) {
            int now = num[start] + num[end];

            if (Math.abs(answer) >= Math.abs(now)) {
                answer = now;
                if (answer == 0) {
                    break;
                }
            }
            if (now > 0) {
                end--;
            } else if (now < 0) {
                start ++;
            }
        }
        System.out.print(answer);
    }
}

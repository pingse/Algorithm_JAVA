import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        long[] sum = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        int k = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 1; i<=n; i++) {
            int count = 0;
            for (int j = i; j<=n; j++) {
                if (sum[j] - sum[i-1] > k) {
                    count = n - j + 1;
                    break;
                }
            }
            answer += count;
        }

        System.out.println(answer);
    }
}

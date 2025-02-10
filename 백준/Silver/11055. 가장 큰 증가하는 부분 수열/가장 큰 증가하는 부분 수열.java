import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static Integer[] sum;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        sum = new Integer[n + 1];
        int max= 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp(n);

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, sum[i]);
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int n) {
        if (sum[n] == null) {
            sum[n] = arr[n];

            for (int i = n - 1; i >= 1; i--) {
                if (arr[i] < arr[n]) {
                    sum[n] = Math.max(sum[n], dp(i) + arr[n]);
                } else {
                    dp(i);
                }
            }

        }
        return sum[n];
    }
}

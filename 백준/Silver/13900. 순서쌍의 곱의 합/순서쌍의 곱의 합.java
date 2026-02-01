import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        long[] sum = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i<=n; i++) {
            sum[i] = sum[i-1] + Long.parseLong(st.nextToken());
        }

        for (int i = 1; i<=n; i++) {
            answer += (sum[i] - sum[i - 1]) * (sum[n] - (sum[i]-sum[i-1]));
        }

        System.out.println(answer/2);
    }
}

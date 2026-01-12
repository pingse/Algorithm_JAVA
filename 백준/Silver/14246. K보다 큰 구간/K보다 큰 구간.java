import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        long answer = 0;

        int l = 1, r=0;
        long sum = 0;

        while(l <= n) {
            while(r + 1 <= n && sum + arr[r+1] <= k) {
                r++;
                sum += arr[r];
            }

            answer += (n - r);

            sum -= arr[l];
            l++;
        }

        System.out.println(answer);
    }
}

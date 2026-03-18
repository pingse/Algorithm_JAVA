import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N*2];

        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i+N] = arr[i];
        }

        for (int i = 0; i<K; i++) {
            sum += arr[i];
        }

        int max = sum;

        for (int i = K; i<N+K; i++) {
            sum -= arr[i-K];
            sum += arr[i];

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        for (int i = 0; i < B; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }

        int sum = 0;

        for (int i = 1; i <= K; i++) {
            sum += arr[i];
        }

        int answer = sum;

        for (int i = K + 1; i <= N; i++) {
            sum += arr[i];
            sum -= arr[i - K];

            answer = Math.min(answer, sum);
        }

        System.out.println(answer);

    }
}

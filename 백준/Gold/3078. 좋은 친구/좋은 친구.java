import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i<N; i++) {
            arr[i] = br.readLine().length();
        }

        int[] count = new int[21];
        long answer = 0;

        for (int i = 0; i<N; i++) {
            int len = arr[i];

            if (i > K) {
                count[arr[i-K-1]]--;
            }

            answer += count[len];
            count[len]++;
        }

        System.out.println(answer);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] A = new long[N];

        long answer = 0;

        for (int i = 0; i<N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long suffixSum = 0;

        for (int i = N-1; i>=0; i--) {
            answer = (answer + A[i] * suffixSum) % 1000000007;
            suffixSum = (suffixSum + A[i]) % 1000000007;
        }

        System.out.println(answer);
    }
}

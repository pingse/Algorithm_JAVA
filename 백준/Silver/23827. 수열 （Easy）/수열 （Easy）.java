import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] A = new long[N+1];

        long answer = 0;

        for (int i = 1; i<=N; i++) {
            A[i] = (A[i-1] + Long.parseLong(st.nextToken())) % 1000000007;
        }

        for (int i = 1; i<N; i++) {
            answer = (answer + ((A[i] - A[i-1]) * (A[N] - A[i])) % 1000000007)%1000000007;
        }

        System.out.println(answer);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(br.readLine());
            int[] C = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) C[i] = Integer.parseInt(st.nextToken());

            boolean[] seen = new boolean[90001];
            int ans = 0;

            for (int a : A)
                for (int b : B)
                    for (int c : C) {
                        int sum = a + b + c;
                        if (!seen[sum] && isLucky(sum)) {
                            seen[sum] = true;
                            ans++;
                        }
                    }

            System.out.println(ans);
        }
    }

    static boolean isLucky(int x) {
        if (x == 0) return false;
        while (x > 0) {
            int d = x % 10;
            if (d != 5 && d != 8) return false;
            x /= 10;
        }
        return true;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i<M; i++) {
            int a = Integer.parseInt(br.readLine());

            int l = 0;
            int r = 0;

            if (a > 0) {
                l = 1;
                r = a;
            } else {
                r = N;
                l = N+a+1;
            }

            if (K >= l && K <= r) {
                K = r + l - K;
            }
        }
        System.out.println(K);
    }
}

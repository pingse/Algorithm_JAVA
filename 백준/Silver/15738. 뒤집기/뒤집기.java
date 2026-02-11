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

            if (a > 0) {
                if (K <= a) {
                    K = a + 1 - K;
                }
            } else {
                int l = N + a + 1;
                if (K >= l) {
                    K = 2 * N + a + 1 - K;
                }
            }
        }
        System.out.println(K);
    }
}

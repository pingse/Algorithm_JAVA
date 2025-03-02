import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            boolean state = false;
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int ax = Integer.parseInt(st.nextToken()) - 1;
            int ay = Integer.parseInt(st.nextToken()) - 1;

            for (int j = ax; j < (M * N); j += M) {
                if (j % N == ay) {
                    state = true;
                    System.out.println(j + 1);
                    break;
                }
            }
            if (!state) {
                System.out.println("-1");
            }
        }
    }
}

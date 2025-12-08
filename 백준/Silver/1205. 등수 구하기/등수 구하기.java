import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] scores = new int[N];
        for (int i = 0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && m <= scores[P-1]) {
            System.out.println(-1);
            return;
        }

        int rank = 1;

        for (int score : scores) {
            if (score > m) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int idx = 0;

        char[] arr = new char[N];
        Arrays.fill(arr, '?');

        for (int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            idx = (idx - (S % N) + N) % N;

            if (arr[idx] != '?' && arr[idx] != c) {
                System.out.println("!");
                return;
            }

            for (int j = 0; j<N; j++) {
                if (arr[j] == c && j != idx) {
                    System.out.println("!");
                    return;
                }
            }

            arr[idx] = c;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<N; i++) {
            sb.append(arr[(idx + i) % N]);
        }
        System.out.println(sb);
    }
}

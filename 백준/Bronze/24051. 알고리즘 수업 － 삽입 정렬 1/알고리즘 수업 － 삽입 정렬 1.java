import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i<N; i++) {
            int idx = i-1;
            int newV = arr[i];

            while(0 <= idx && newV < arr[idx]) {
                arr[idx+1] = arr[idx];
                idx--;
                K--;

                if (K == 0) {
                    System.out.println(arr[idx+1]);
                    return;
                }
            }

            if (idx + 1 != i) {
                arr[idx+1] = newV;
                K--;
            }

            if (K == 0) {
                System.out.println(newV);
                return;
            }
        }

        System.out.println(-1);
    }
}

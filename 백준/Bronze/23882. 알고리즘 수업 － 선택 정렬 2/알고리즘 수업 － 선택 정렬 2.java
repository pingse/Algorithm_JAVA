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

        for (int i = N-1; i>=1; i--) {
            int max = arr[i];
            int count = i;
            for (int j = 0; j<i; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    count = j;
                }
            }

            if (count == i) continue;

            arr[count] = arr[i];
            arr[i] = max;
            K--;

            if (K == 0) {
                for (int k = 0; k<N; k++) {
                    System.out.print(arr[k] + " ");
                }
                return;
            }
        }

        System.out.println("-1");
    }
}

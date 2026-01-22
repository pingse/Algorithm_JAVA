import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];

        int section = (9*m + 9) / 10;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int maxCount = 0;
        int[] count = new int[1000001];
        for (int i = 0; i<m; i++) {
            int v = A[i];
            count[v]++;
            if(count[v] > maxCount) {
                maxCount = count[v];
            }
        }

        if (maxCount >= section) {
            System.out.println("YES");
            return;
        }

        for (int i = m; i<n; i++) {
            int out = A[i - m];
            int in = A[i];

            count[out]--;
            count[in]++;

            if (count[in] > maxCount) {
                maxCount = count[in];
            }

            if (maxCount >= section) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}

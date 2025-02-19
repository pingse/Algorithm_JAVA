import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int total = 0;

        Integer[] A = new Integer[n];
        int[] B = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            total += A[i] * B[i];
        }
        System.out.print(total);
    }
}

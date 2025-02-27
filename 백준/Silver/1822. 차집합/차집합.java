import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int lengthA = Integer.parseInt(st.nextToken());
        int lengthB = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        A = new int[lengthA];
        B = new int[lengthB];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < lengthA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < lengthB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
        int count = 0;
        for (int i = 0; i < lengthA; i++) {
            if (!binarySearch(A[i])) {
                count++;
                sb.append(A[i] + " ");
            }
        }
        bw.write(count + "\n");
        if (count != 0) {
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean binarySearch(int n) {
        int start = 0;
        int end = B.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (B[mid] < n) {
                start = mid + 1;
            } else if (B[mid] > n) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

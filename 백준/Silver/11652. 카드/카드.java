import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int max = 1;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        int[] counts = new int[n];
        Arrays.sort(arr);
        long temp = arr[0];
        counts[0] = 1;
        for (int i = 1; i < n; i++) {
            counts[i] = 1;
            if (arr[i-1] == arr[i]) counts[i] = counts[i-1] +1 ;
            if (counts[i] > max) {
                max = counts[i];
                temp = arr[i];
            }
        }

        bw.write(Long.toString(temp));
        bw.flush();
        bw.close();
        br.close();
    }
}

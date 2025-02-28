import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int midL = 0, midR = 0;
        int value = Integer.MAX_VALUE;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (value > Math.abs(sum)) {
                value = Math.abs(sum);
                midL = arr[start];
                midR = arr[end];
            }

            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }
        bw.write(Integer.toString(midL) + " " + Integer.toString(midR));
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] arr = new int[m];
            long answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = arr[m - 1];

            for (int j = m - 2; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    continue;
                }

                answer += (max - arr[j]);
            }
            bw.write(Long.toString(answer) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

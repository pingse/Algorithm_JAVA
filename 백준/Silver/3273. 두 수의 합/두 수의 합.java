import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] array;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        int start = 1;
        int end = N;
        int count = 0;

        Arrays.sort(array);

        while (start < end) {
            int a = array[start] + array[end];

            if (a == K) {
                count++;
            }

            if (a < K) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}

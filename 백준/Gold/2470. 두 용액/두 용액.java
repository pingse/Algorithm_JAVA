import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;

        int temp = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (start < end) {
            int value = arr[start] + arr[end];
            if (Math.abs(value) < Math.abs(temp)) {
                temp = value;
                answer1 = arr[start];
                answer2 = arr[end];
                if (value == 0) {
                    break;
                }
            }

            if (value < 0) {
                start++;
            } else {
                end--;
            }

        }
        bw.write(Integer.toString(answer1) + " " + Integer.toString(answer2));

        bw.flush();
        bw.close();
        br.close();
    }
}

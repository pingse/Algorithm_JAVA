import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dist = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dist[0] = Integer.MIN_VALUE;
        int len = 0, idx = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > dist[len]) {
                dist[++len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i]);
                dist[idx] = arr[i];
            }
        }
        bw.write(Integer.toString(len));
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int left, int right, int value) {
        int mid = 0;
        while (left < right) {
            mid = (left + right)/2;

            if (dist[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

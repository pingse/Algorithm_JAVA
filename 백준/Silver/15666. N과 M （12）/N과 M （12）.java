import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, answer;
    static int n, m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        nm(0);
        bw.flush();
        bw.close();
        br.close();

    }

    static void nm(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(Integer.toString(answer[i]) + " ");
            }
            bw.write("\n");
            return;
        }
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (temp != arr[i]) {
                if (depth != 0) {
                    if (arr[i] < answer[depth-1]) continue;
                }
                answer[depth] = arr[i];
                temp = answer[depth];
                nm(depth + 1);
            }
        }
    }
}

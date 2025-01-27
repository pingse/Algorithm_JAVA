import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[n];

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
                bw.write(Integer.toString(arr[answer[i]]) + " ");
            }
            bw.write("\n");
            return;
        }

        int s = 0;
        if (depth != 0) {
            s = answer[depth -1] + 1;
        }
        for (int i = s; i < n; i++) {
            answer[depth] = i;
            nm(depth+1);
        }
    }

}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] arr;
    static int max = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        rock(0);
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static void rock(int depth) {
        if (depth == n) {
            max = Math.max(max, count);
            return;
        }

        if (arr[depth][0] <= 0 || count == n - 1) {
            rock(depth + 1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == depth || arr[i][0] <= 0) continue;

            arr[i][0] -= arr[depth][1];
            arr[depth][0] -= arr[i][1];
            if (arr[i][0] <= 0) count++;
            if (arr[depth][0] <= 0) count++;
            rock(depth+1);
            if (arr[i][0] <= 0) count--;
            if (arr[depth][0] <= 0) count--;
            arr[i][0] += arr[depth][1];
            arr[depth][0] += arr[i][1];

        }
    }
}

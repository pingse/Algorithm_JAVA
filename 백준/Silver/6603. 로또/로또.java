import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] answer;
    static boolean[] isUsed;
    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            } else {
                arr = new int[n];
                answer = new int[6];
                isUsed = new boolean[n];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            lotto(0, 0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void lotto(int depth, int s) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(Integer.toString(answer[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = s; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                answer[depth] = arr[i];
                lotto(depth + 1, i+1);
                isUsed[i] = false;
            }
        }
    }
}

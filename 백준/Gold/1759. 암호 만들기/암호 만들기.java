import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static char[] arr;
    static char[] answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[m];
        answer = new char[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        pass(0, 0, 0);
        bw.flush();
        bw.close();
        br.close();
    }

    static void pass(int depth, int s, int count) throws IOException {
        if (depth == n) {
            if (count == 0 || n - count < 2) {
                return;
            }
            for (int i = 0; i < n; i++) {
                bw.write(answer[i]);
            }
            bw.write("\n");
            return;
        }

        for (int i = s; i < m; i++) {
            answer[depth] = arr[i];
            if (answer[depth] == 'a' || answer[depth] == 'e' || answer[depth] == 'i' || answer[depth] == 'o' || answer[depth] == 'u') {
                pass(depth + 1, i + 1, count + 1);
            } else {
                pass(depth + 1, i + 1, count);
            }
        }
    }
}

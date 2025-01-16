import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int m;
        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            m = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast()[0] > m) {
                deque.removeLast();
            }

            deque.addLast(new int[]{m, i});

            if (deque.peekFirst()[1] < i - l + 1) {
                deque.removeFirst();
            }

            bw.write(Integer.toString(deque.peekFirst()[0]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

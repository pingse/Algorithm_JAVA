import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
        bw.write("<");
        while (!deque.isEmpty()) {
            if (count == a-1) {
                bw.write(Integer.toString(deque.pollFirst()));
                if (!deque.isEmpty()) {
                    bw.write(", ");
                }
                count = 0;
            } else {
                deque.offer(deque.pollFirst());
                count++;
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.lang.System.in;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Integer a;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(br.readLine());
            if (a == 0) {
                a = queue.poll();
                if (a != null) {
                    bw.write(Integer.toString(a) + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                queue.offer(a);
            }
        }
        bw.flush();
        bw.close();
    }
}

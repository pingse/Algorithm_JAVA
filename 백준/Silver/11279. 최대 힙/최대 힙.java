import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.lang.System.in;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Integer a;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(br.readLine());
            if (a == 0) {
                a = queue.poll();
                if (a != null) {
                    System.out.println(a);
                } else {
                    System.out.println("0");
                }
            } else {
                queue.offer(a);
            }
        }
    }
}

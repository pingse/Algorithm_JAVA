import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.add((long) start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long cur = queue.poll();

                if (cur == end) {
                    System.out.print(count + 1);
                    System.exit(0);
                }
                if (cur * 2 <= end) queue.add(cur * 2);
                if (cur * 10 + 1 <= end) queue.add(cur * 10 + 1);
            }
            count++;
        }

        System.out.print("-1");
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int next = 0;
        int count = 0;
        int temp = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque1.addLast(i);
            deque2.addLast(i);
        }
        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            next = Integer.parseInt(st.nextToken());
            temp = 0;

            while(true) {
                if (deque1.peekFirst() == next) {
                    deque1.pollFirst();
                    deque2 = new LinkedList<>(deque1);
                    break;
                } else if (deque2.peekFirst() == next) {
                    deque2.pollFirst();
                    deque1 = new LinkedList<>(deque2);
                    break;
                } else {
                    deque1.addLast(deque1.pollFirst());
                    deque2.addFirst(deque2.pollLast());
                    temp++;
                }
            }
            count += temp;
        }

        bw.write(Integer.toString(count));
        bw.close();
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str = st.nextToken();

            switch (str) {
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    bw.write((!deque.isEmpty() ? Integer.toString(deque.pollFirst()) : "-1") + "\n");
                    break;

                case "pop_back":
                    bw.write((!deque.isEmpty() ? Integer.toString(deque.pollLast()) : "-1") + "\n");
                    break;

                case "size":
                    bw.write(Integer.toString(deque.size()) + "\n");
                    break;

                case "empty":
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");
                    break;

                case "front":
                    bw.write((!deque.isEmpty() ? Integer.toString(deque.peekFirst()) : "-1") + "\n");
                    break;

                case "back":
                    bw.write((!deque.isEmpty() ? Integer.toString(deque.peekLast()) : "-1") + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

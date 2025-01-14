import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str;

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str = st.nextToken();

            switch(str) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    bw.write((queue.isEmpty() ? "-1" : Integer.toString(queue.poll())) + "\n");
                    break;

                case "size":
                    bw.write(Integer.toString(queue.size()) + "\n");
                    break;

                case "empty":
                    bw.write(queue.isEmpty() ? "1\n" : "0\n");
                    break;

                case "front":
                    bw.write((queue.isEmpty() ? "-1" : Integer.toString(queue.getFirst())) + "\n");
                    break;

                case "back":
                    bw.write((queue.isEmpty() ? "-1" : Integer.toString(queue.getLast())) + "\n");
                    break;

            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

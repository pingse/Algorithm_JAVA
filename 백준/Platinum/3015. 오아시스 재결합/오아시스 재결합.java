import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        Stack<Node> stack = new Stack<>();
        int height = 0;
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            a = Integer.parseInt(br.readLine());
            Node node = new Node(a, 1);

            while (!stack.isEmpty() && stack.peek().cur <= a) {
                Node previous = stack.pop();
                cnt += previous.cnt;
                if (previous.cur == a) {
                    node.cnt += previous.cnt;
                }
            }

            if (!stack.isEmpty()) {
                cnt += 1;
            }

            stack.push(node);

        }

        bw.write(Long.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int cur;
        long cnt;

        public Node(int cur, long cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }

}

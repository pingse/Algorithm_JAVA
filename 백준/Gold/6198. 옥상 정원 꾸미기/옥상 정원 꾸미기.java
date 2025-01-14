import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        int now;

        for (int i = 1; i <= n; i++) {
            now = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= now) {
                    stack.pop();
                } else break;
            }
            ans += stack.size();
            stack.push(now);
        }
        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

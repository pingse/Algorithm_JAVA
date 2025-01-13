import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int now = 0;
        int next;

        for (int i = 0; i < n; i++) {
            next = Integer.parseInt(br.readLine());

            if (next > now) {
                for (int j = now + 1; j <= next; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                now = next;
            }

            else if (stack.peek() != next) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        br.close();
        System.out.println(sb);
    }
}

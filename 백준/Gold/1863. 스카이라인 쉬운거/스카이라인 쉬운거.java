import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        int answer = 0;
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                if (y == 0) continue;
                
                stack.push(y);
                continue;
            }

            if (stack.peek() > y) {
                while(!stack.isEmpty()) {
                    if (stack.peek() <= y) break;

                    stack.pop();
                    answer++;
                }

                if (y == 0) continue;

                if (stack.isEmpty() || stack.peek() < y) stack.push(y);
            } else if (stack.peek() < y) {
                stack.push(y);
            }
        }

        if (!stack.isEmpty()) answer += stack.size();

        System.out.println(answer);
    }
}

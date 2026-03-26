import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> stack = new ArrayDeque<>();

        String str = br.readLine();

        for (int i = 0; i<N; i++) {
            int cur = str.charAt(i) - '0';

            while(!stack.isEmpty() && K > 0 && stack.peekLast() < cur) {
                stack.pollLast();
                K--;
            }

            stack.addLast(cur);
        }

        while(K > 0) {
            stack.pollLast();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : stack) sb.append(c);
        System.out.println(sb.toString());
    }
}

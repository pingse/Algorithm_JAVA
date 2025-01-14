import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int now;
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for (int i = 1; i <= n; i++) {
            now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if(stack.peek()[1] >= now) {
                    bw.write(Integer.toString(stack.peek()[0]) + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                bw.write("0 ");
            }
            stack.push(new int[]{i, now});
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

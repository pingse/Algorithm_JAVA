import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str = st.nextToken();
            switch (str) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    bw.write(stack.isEmpty() ? "-1\n" : (Integer.toString(stack.peek()) + "\n"));
                    break;
                case "size":
                    bw.write(Integer.toString(stack.size()) + "\n");
                    break;
                case "empty":
                    bw.write(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case "pop":
                    bw.write(stack.isEmpty() ? "-1\n" : (Integer.toString(stack.pop()) + "\n"));
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        String str;
        int count = 0;

        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(j));
                } else {
                    if (stack.peek() == str.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(j));
                    }
                }

            }
            if (stack.isEmpty()) {
                count++;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}

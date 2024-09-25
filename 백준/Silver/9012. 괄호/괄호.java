import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            stack.clear();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else {
                    if (stack.isEmpty()) {
                        bw.write("NO\n");
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (j == str.length() - 1) {
                    if (stack.isEmpty()) {
                        bw.write("YES\n");
                    } else {
                        bw.write("NO\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}

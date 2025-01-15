import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean state = false;
        int result = 0;
        int now = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                stack.push('[');
                now *= 3;
            } else if (str.charAt(i) == '(') {
                stack.push('(');
                now *= 2;
            } else {
                if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        state = true;
                        break;
                    }
                    if (str.charAt(i - 1) == '[') {
                        result += now;
                    }
                    stack.pop();
                    now /= 3;
                } else if (str.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        state = true;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        result += now;
                    }
                    stack.pop();
                    now /= 2;
                } else {
                    state = true;
                    break;
                }
            }
        }
        
        if (!stack.isEmpty() || state) {
            bw.write("0");
        } else {
            bw.write(Integer.toString(result));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Stack<Character> stack1;
        Stack<Character> stack2;
        String str;
        int c;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            str = br.readLine();
            c = 0;

            while (true) {
                if (c == str.length()) {
                    break;
                }
                switch (str.charAt(c)) {
                    case '<':
                        if (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                        break;
                    case '>':
                        if (!stack2.isEmpty()) {
                            stack1.push(stack2.pop());
                        }
                        break;
                    case '-':
                        if (!stack1.isEmpty()) {
                            stack1.pop();
                        }
                        break;
                    default:
                        stack1.push(str.charAt(c));
                }
                c++;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            while (!stack2.isEmpty()) {
                bw.write(stack2.pop());
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

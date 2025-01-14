import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.pop();

                if (str.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans++;
                }
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

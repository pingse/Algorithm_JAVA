import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        if (n == 0) {
            bw.write("0");
        }

        while (n != 0) {
            stack.add(Math.abs(n % -2));
            n = (int) Math.ceil((double) n / -2);
        }
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            bw.write(Integer.toString(stack.pop()));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

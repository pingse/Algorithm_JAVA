import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        bw.write(Long.toString(factorial(n)));
        bw.flush();
        bw.close();
    }

    static long factorial(int n) {
        if (n < 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

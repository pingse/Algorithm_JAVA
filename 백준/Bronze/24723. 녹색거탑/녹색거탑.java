import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans = 2;
            } else {
                ans *= 2;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}

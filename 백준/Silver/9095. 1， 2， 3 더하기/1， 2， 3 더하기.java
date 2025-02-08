import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int value;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            value = Integer.parseInt(br.readLine());
            bw.write(Integer.toString(dp(value)) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            return dp(n - 1) + dp(n - 2) + dp(n - 3);
        }
    }
}

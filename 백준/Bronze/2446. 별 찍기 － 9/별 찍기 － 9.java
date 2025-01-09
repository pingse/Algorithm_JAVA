import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            bw.write(" ".repeat(i) + "*".repeat(2*(n-i)-1) +"\n");
        }
        for (int i = n; i > 1; i--) {
            bw.write(" ".repeat(i-2) + "*".repeat(2*(n-i+1)+1) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

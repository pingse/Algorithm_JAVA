import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            bw.write( "*".repeat(i+1)+" ".repeat(2*(n-i-1))+"*".repeat(i+1)+"\n");
        }
        for (int i = n; i>1; i--) {
            bw.write( "*".repeat(i-1)+" ".repeat(2*(n-i) + 2)+"*".repeat(i-1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

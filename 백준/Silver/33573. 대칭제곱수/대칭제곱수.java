import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb;

        for (int i = 0; i<n; i++) {
            String num = br.readLine();

            sb = new StringBuilder(num);
            long a = Long.parseLong(num);
            long b = Long.parseLong(sb.reverse().toString());
            if (Math.sqrt(a) % 1 == 0 && Math.sqrt(b) % 1 == 0) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

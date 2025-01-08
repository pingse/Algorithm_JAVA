import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a != b) {
            long temp = 0;
            if (a > b) {
                temp = a;
                a = b;
                b = temp;
            }

            a++;
            bw.write(Long.toString(b - a) + "\n");
            while (a != b) {
                bw.write(Long.toString(a++) + " ");

            }
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

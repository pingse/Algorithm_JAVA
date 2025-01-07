import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int min = Integer.MAX_VALUE;
        int total = 0;
        int value;

        for (int i = 0; i < 7; i++) {
            value = Integer.parseInt(br.readLine());

            if (value % 2 == 1) {
                if (value < min) {
                    min = value;
                }
                total += value;
            }
        }
        if (total == 0) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(total) + "\n");
            bw.write(Integer.toString(min));
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

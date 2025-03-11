import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = 2; j <= num; j++) {
                int count = 0;
                while (num % j == 0) {
                    count++;
                    num/=j;
                }
                if (count != 0) {
                    bw.write(j + " " + count + "\n");
                }
                if (num == 0) {
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] fibo = new int[46];

        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i <=45; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());
            bw.write(fibo[next] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

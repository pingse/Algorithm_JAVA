import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            int count = 0;
            boolean[] num = new boolean[k + 1];
            for (int j = 1; j <= k; j++) {
                for (int z = j; z <= k; z += j) {
                    num[z] = !num[z];
                }
            }
            for (int j = 1; j <= k; j++) {
                if (num[j]) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
